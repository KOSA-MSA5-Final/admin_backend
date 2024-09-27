package com.example.demo.config.jwt;

import com.example.demo.domains.member.entity.Member;
import com.example.demo.domains.member.entity.RefreshToken;
import com.example.demo.domains.member.service.interfaces.RefreshTokenService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Collections;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class JwtTokenProvider {
    private final JwtProperties jwtProperties;
    //secret_key, issuer등 제공
    private final RefreshTokenService refreshTokenService;

    public String generateToken(Member user, Duration expiredAt) {
        Date now = new Date();
        return makeToken(new Date(now.getTime()+expiredAt.toMillis()), user);
    }

    // Refresh Token 생성 메소드
    public RefreshToken generateRefreshToken(Long userId) {
        // 새 리프레시 토큰 생성 (예: UUID를 사용)
        String newRefreshToken = UUID.randomUUID().toString();

        // 새로운 RefreshToken 객체 생성
        RefreshToken refreshToken = new RefreshToken(userId, newRefreshToken);

        // 데이터베이스에 저장
        return refreshTokenService.saveRefreshToken(refreshToken);
    }

    //jwt토큰 생성 메소드
    private String makeToken(Date expiry, Member user) {
        Date now = new Date();
        
        return Jwts.builder()
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE) //헤더 typ: JWT
                //내용 iss: nasnju@gmail.com(properties 파일에서 설정한 값)
                .setIssuer(jwtProperties.getIssuer())
                .setIssuedAt(now) //내용 iat: 현재시간
                .setExpiration(expiry) //내용 exp: expiry 멤버 변숫값
                .setSubject(user.getEmail()) //내용 sub: 유저의 이메일
                .claim("id", user.getMember_id()) //클레임 id : 유저 ID
                //서명: 비밀값과 함께 해시값을 HS256 방식으로 암호화
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecretKey())
                .compact();
    }

    //토큰 기반으로 인증정보를 가져오는 메서드
    public Authentication getAuthentication(String token) {
        Claims claims =getClaims(token);
        Set<SimpleGrantedAuthority> authorities =
                Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));

        return new UsernamePasswordAuthenticationToken(
                new org.springframework.security.core.userdetails.User(claims.getSubject(), "", authorities)
                , token
                , authorities
        );
    }
    
    //jwt토큰 유효성 검증 매서드
    public boolean validToken(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(jwtProperties.getSecretKey()) //비밀값으로 복호화
                    .parseClaimsJws(token);

            return true;
        }catch(Exception e) { //복호화과정에서 에러가 나면 유효하지 않은 토큰
            return false;
        }

    }


    //토큰 기반으로 유저 ID를 가져오는 메소드
    public Long getUserId(String token){
        Claims claims = getClaims(token);
        return claims.get("id", Long.class);
    }


    private Claims getClaims(String token){
        return Jwts.parser()
                .setSigningKey(jwtProperties.getSecretKey())
                .parseClaimsJws(token)
                .getBody();
    }

}
