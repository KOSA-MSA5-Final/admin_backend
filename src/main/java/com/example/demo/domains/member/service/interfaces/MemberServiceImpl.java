package com.example.demo.domains.member.service.interfaces;

import com.example.demo.domains.member.dto.AddUserRequest;
import com.example.demo.domains.member.dto.JoinDTO;
import com.example.demo.domains.member.dto.MemberDTO;
import com.example.demo.domains.member.entity.Member;
import com.example.demo.domains.member.repository.MemberRepository;
import com.example.demo.domains.member.service.impls.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    public void joinProcess(JoinDTO joinDTO) {

        String username = joinDTO.getUsername();
        String password = joinDTO.getPassword();
        String name = joinDTO.getName();
        String email = joinDTO.getEmail();
        String telNumber = joinDTO.getTelNumber();

        Boolean isExist = memberRepository.existsByUsername(username);

        if (isExist) {

            return;
        }

        Member data = new Member();

        data.setUsername(username);
        data.setName(name);
        data.setEmail(email);
        data.setTelNum(telNumber);
        data.setPassword(bCryptPasswordEncoder.encode(password));
        data.setRole("ROLE_ADMIN");

        memberRepository.save(data);
    }


    public List<Member> findAllMembers(){
        List<Member> members = memberRepository.findAll();
        return members;
    }

    @Override
    public Member findMemberByEmail(String email) {
        Member byEmail = memberRepository.findByEmail(email).get();
        return byEmail;
    }

    @Override
    public Boolean deleteMember(Member member) {
        try {
            memberRepository.delete(member);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public void updateMember(MemberDTO memberDTO) {
        Member byUsername = memberRepository.findByUsername(memberDTO.getUsername());
        byUsername.setName(memberDTO.getName());
        byUsername.setEmail(memberDTO.getEmail());
        byUsername.setTelNum(memberDTO.getTelNum());
        memberRepository.save(byUsername);
    }

}
