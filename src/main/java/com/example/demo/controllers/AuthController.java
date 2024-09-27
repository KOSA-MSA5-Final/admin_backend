package com.example.demo.controllers;

import com.example.demo.config.jwt.JwtTokenProvider;
import com.example.demo.domains.member.dto.AddUserRequest;
import com.example.demo.domains.member.dto.LoginRequest;
import com.example.demo.domains.member.dto.LoginResponse;
import com.example.demo.domains.member.dto.MemberDTO;
import com.example.demo.domains.member.entity.Member;
import com.example.demo.domains.member.entity.RefreshToken;
import com.example.demo.domains.member.repository.MemberRepository;
import com.example.demo.domains.member.service.impls.MemberService;
import com.example.demo.domains.member.service.interfaces.RefreshTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.token.TokenService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:80") // 해당 컨트롤러에만 CORS 설정
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController { //로그인 관련 컨트롤러
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider tokenProvider;
    private final RefreshTokenService refreshTokenService;
    private final MemberService memberService;
    private final MemberRepository memberRepository;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        System.out.println("=====================로그인요청");
        System.out.println(loginRequest.getEmail());

        try {
            // 이메일과 비밀번호로 인증 시도
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getEmail(),
                            loginRequest.getPassword()
                    )
            );

            // 인증이 성공했을 때 사용자 정보 가져오기
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            Optional<Member> byEmail = memberRepository.findByEmail(loginRequest.getEmail());
            Member user = byEmail.get();

            // 기존의 Refresh Token 확인
            System.out.println("1번위치예요");
            RefreshToken existingRefreshToken = refreshTokenService.findByUserId(user.getMember_id());
            System.out.println("2번위치입니다");

            if(existingRefreshToken != null) {
                //이미 생성된 refresh token이 있는 경우, 기존 토큰 사용
                String accessToken = tokenProvider.generateToken(user, Duration.ofDays(1)); // 새로운 액세스 토큰 생성
                // 응답으로 토큰 전송
                return ResponseEntity.ok(new LoginResponse(accessToken, existingRefreshToken));
            }else{
                //새로운 Access Token과 Refresh Token 생성
                String accessToken = tokenProvider.generateToken(user, Duration.ofDays(1)); // 하루 유효한 액세스 토큰
                RefreshToken refreshToken = tokenProvider.generateRefreshToken(user.getMember_id()); // 리프레시 토큰

                // Refresh Token 저장
                refreshTokenService.saveRefreshToken(refreshToken);

                // 응답으로 토큰 전송
                return ResponseEntity.ok(new LoginResponse(accessToken, refreshToken));
            }



        } catch (AuthenticationException e) {
            System.err.println("인증 실패: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 정보가 올바르지 않습니다.");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody AddUserRequest request) {
        System.out.println("============================회원가입메소드입니다");
        memberService.saveMember(request);
        Member specificMember = memberService.findMemberByEmail(request.getEmail());
        jwtTokenProvider.generateRefreshToken(specificMember.getMember_id());

        return ResponseEntity.ok("User registered successfully");
    }
}
