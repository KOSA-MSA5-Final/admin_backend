package com.example.demo.domains.member.service.interfaces;


import com.example.demo.domains.member.entity.RefreshToken;
import com.example.demo.domains.member.repository.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RefreshTokenService {
    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshToken findByRefreshToken(String refreshToken) {
        return refreshTokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow(() -> new IllegalArgumentException("없는 사용자입니다"));
    }

    // 새로운 리프레시 토큰 저장 메소드
    public RefreshToken saveRefreshToken(RefreshToken refreshToken) {
        return refreshTokenRepository.save(refreshToken);
    }

    public RefreshToken findByUserId(Long userId) {
        return refreshTokenRepository.findByUserId(userId).get();
    }
}
