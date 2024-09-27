package com.example.demo.util;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class UTCtoKorea {
    public static Date convertUTCToKoreanTime(Date utcDate) {
        // Date를 Instant로 변환
        Instant instant = utcDate.toInstant();

        // Instant를 한국 시간대의 ZonedDateTime으로 변환
        ZonedDateTime koreanZonedDateTime = instant.atZone(ZoneId.of("Asia/Seoul"));

        // ZonedDateTime을 다시 Date로 변환
        return Date.from(koreanZonedDateTime.toInstant());
    }
}
