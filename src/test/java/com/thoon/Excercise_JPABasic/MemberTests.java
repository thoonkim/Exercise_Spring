package com.thoon.Excercise_JPABasic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import com.thoon.Excercise_JPABasic.domain.Member;
import com.thoon.Excercise_JPABasic.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberTests {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @DisplayName("testList01")
    public void testList01() {
        Iterable<Member> memberList = memberRepository.findAll();

        for(Member member : memberList) {
            System.out.println(member);
        }
    }

    @Test
    @DisplayName("testList02")
    public void testList02() {
        List<Long> idList = new ArrayList<Long>();

        Long id1 = 1L;
        Long id2 = 2L;

        idList.add(id1);
        idList.add(id2);

        Iterable<Member> memberList = memberRepository.findAllById(idList);

        for(Member member : memberList) {
            System.out.println(member);
        }
    }

    @Test
    @DisplayName("testModify")
    public void testModify() {
        Optional<Member> memberOptional = memberRepository.findById(1L);

        if (memberOptional.isPresent()) {
            Member member = memberOptional.get();
            member.setUserName("Alexander");

            memberRepository.save(member);
        }
    }

    @Test
    @DisplayName("testRead")
    public void testRead() {
        Optional<Member> memberOptional = memberRepository.findById(1L);

        if (memberOptional.isPresent()){
            Member member = memberOptional.get();

            System.out.println(member);
        }
    }

    @Test
    @DisplayName("testRegister01")
    public void testRegister01() {
        Member member1 = new Member();
        member1.setUserId("jupiter");
        member1.setUserPw("1234");
        member1.setUserName("Alex");

        memberRepository.save(member1);

        Member member2 = new Member();
        member2.setUserId("venus");
        member2.setUserPw("4567");
        member2.setUserName("Olivia");

        memberRepository.save(member2);

        Member member3 = new Member();
        member3.setUserId("mercury");
        member3.setUserPw("9876");
        member3.setUserName("Tyler");

        memberRepository.save(member3);
    }

    @Test
    @DisplayName("testRemove01")
    public void testRemove01() {
        memberRepository.deleteById(2L);
    }

    @Test
    @DisplayName("testRemove02")
    public void testRemove02() {
        Optional<Member> memberOptional = memberRepository.findById(1L);

        if (memberOptional.isPresent()) {
            Member member = memberOptional.get();

            memberRepository.delete(member);
        }
    }

    @Test
    @DisplayName("testRemove03")
    public void testRemove03() {
        memberRepository.deleteAll();
    }

    @Test
    @DisplayName("testRegister02")
    public void testRegister02() {
        List<Member> memberList = new ArrayList<Member>();

        Member member1 = new Member();
        member1.setUserId("jupiter");
        member1.setUserPw("1234");
        member1.setUserName("Alex");

        memberList.add(member1);

        Member member2 = new Member();
        member2.setUserId("venus");
        member2.setUserPw("4567");
        member2.setUserName("Olivia");

        memberList.add(member2);

        Member member3 = new Member();
        member3.setUserId("mercury");
        member3.setUserPw("9876");
        member3.setUserName("Tyler");

        memberList.add(member3);

        memberRepository.saveAll(memberList);
    }

}
