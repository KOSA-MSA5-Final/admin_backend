package com.example.demo.domains.member.service.interfaces;

import com.example.demo.domains.member.entity.MyLocation;
import com.example.demo.domains.member.repository.MyLocationRepository;
import com.example.demo.domains.member.service.impls.MyLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
 * 2024-09-24       나선주          메소드(조회, 삭제, 생성) 생성
 */
@Service
public class MyLocationServiceImpl implements MyLocationService {
    @Autowired
    private MyLocationRepository myLocationRepository;

    @Override
    public MyLocation saveMyLocation(MyLocation myLocation) {
        return myLocationRepository.save(myLocation);
    }

    @Override
    public List<MyLocation> findAllMyLocation() {
        List<MyLocation> all = myLocationRepository.findAll();
        return all;
    }

    @Override
    public Boolean deleteMyLocation(MyLocation myLocation) {
        try{
            myLocationRepository.delete(myLocation);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
