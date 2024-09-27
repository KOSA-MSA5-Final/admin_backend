package com.example.demo.domains.member.service.impls;

import com.example.demo.domains.member.entity.Member;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class MemberServiceTest {
    @Autowired
    MemberService memberService;

    /*@Test
    void saveMember() {
        Member member = new Member(
                1,
                "나선주",
                "nasnju@naver.com",
                "1234",
                "01022222222"
        );
        Member member1 = memberService.saveMember(member);
        assertNotNull(member1);
    }
*/
    @Test
    void findAllMembers() {
        List<Member> members = memberService.findAllMembers();
        System.out.println("========================멤버는있나요?");
        System.out.println(members.size()+"명 있어요");
        assertNotNull(members);
    }

    @Test
    void findMemberByEmail() {
        assertNotNull(memberService.findMemberByEmail("nasnju@naver.com"));
    }

    @Test
    @Transactional
    void deleteMember() {
        Member memberByEmail = memberService.findMemberByEmail("nasnju@naver.com");
        Boolean b = memberService.deleteMember(memberByEmail);
        assertTrue(b);
    }
}