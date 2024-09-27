package com.example.demo.domains.member.service.interfaces;

import com.example.demo.config.jwt.JwtTokenProvider;
import com.example.demo.domains.member.entity.Member;
import com.example.demo.domains.member.repository.MemberRepository;
import com.example.demo.domains.member.service.impls.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TokenService {
    private final MemberService memberService;

    private final RefreshTokenService refreshTokenService;
    private final JwtTokenProvider tokenProvider;
    private final MemberRepository memberRepository;

    public String createNewAccessToken(String refreshToken) {
        //토큰 유효성 검사에 실패하면 예외 발생
        if(!tokenProvider.validToken(refreshToken)){
            throw new IllegalArgumentException("토큰 유효성 검사에 실패했습니다, tokenService를 참고하세요");
        }

        Long userId = refreshTokenService.findByRefreshToken(refreshToken).getUserId();
        Optional<Member> byId = memberRepository.findById(userId);
        Member user = byId.get();

        return tokenProvider.generateToken(user, Duration.ofDays(1)); //토큰 지속시간 : 하루
    }

}
