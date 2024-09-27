package com.example.demo.domains.member.service.impls;


import com.example.demo.domains.member.entity.MyLocation;

import java.util.List;

/**
 * author : 나선주
 * date : 2024-09-24
 * description : MemberService
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2024-09-24       나선주          최초 생성
 * 2024-09-24       나선주          method생성(CRD)
 */
public interface MyLocationService {
    //배송지 등록
    MyLocation saveMyLocation(MyLocation myLocation);
    //전체 배송지 가져오기
    List<MyLocation> findAllMyLocation();
    //배송지 삭제
    Boolean deleteMyLocation(MyLocation myLocation);
}
