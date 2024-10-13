//package com.example.demo.domains.member.service.impls;
//
//import com.example.demo.domains.member.entity.Member;
//import com.example.demo.domains.member.entity.MyLocation;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@ActiveProfiles("test")
//class MyLocationServiceTest {
//    @Autowired
//    MyLocationService myLocationService;
//    @Autowired
//    MemberService memberService;
//
//    @Test
//    void saveMyLocation() {
//        MyLocation myLocation = new MyLocation();
//        myLocation.setId(1L);
//        myLocation.setAddress("서울특별시 동래구 어쩌구");
//        Member memberByEmail = memberService.findMemberByEmail("nasnju@naver.com");
//        myLocation.setMember(memberByEmail);
//        myLocation.setIsPrimary("is");
//        MyLocation myLocation1 = myLocationService.saveMyLocation(myLocation);
//        assertNotNull(myLocation1);
//    }
//
//    @Test
//    void findAllMyLocation() {
//        List<MyLocation> myLocations = myLocationService.findAllMyLocation();
//        assertNotNull(myLocations);
//    }
//
//    @Test
//    @Transactional
//    void deleteMyLocation() {
//        List<MyLocation> allMyLocation = myLocationService.findAllMyLocation();
//        MyLocation first = allMyLocation.getFirst();
//        Boolean b = myLocationService.deleteMyLocation(first);
//        assertTrue(b);
//    }
//}