package com.dohan.doj.service;

import com.dohan.doj.constant.MemberRole;
import com.dohan.doj.dto.MemberDto;
import com.dohan.doj.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired
    MemberServiceImpl memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    void join() {
        MemberDto memberDto = new MemberDto();
        memberDto.setNickname("dohan");
        memberDto.setEmail("rhdehgks@naver.com");
        memberDto.setPassword("12341234");
        memberDto.setMemberRole(MemberRole.USER);

        MemberDto memberDto1 = new MemberDto();
        memberDto1.setNickname("dohan2");
        memberDto1.setEmail("rhdehgks2@naver.com");
        memberDto1.setPassword("123412342");
        memberDto1.setMemberRole(MemberRole.USER);

        MemberDto memberDto2 = new MemberDto();
        memberDto2.setNickname("dohan3");
        memberDto2.setEmail("hello@naver.com");
        memberDto2.setPassword("12341234");
        memberDto2.setMemberRole(MemberRole.USER);

        memberService.join(memberDto);
        memberService.join(memberDto1);
        memberService.join(memberDto2);
        List<MemberDto> all = memberService.findAll();
        System.out.println(Arrays.toString(all.toArray()));

    }
}
