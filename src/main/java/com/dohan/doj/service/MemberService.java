package com.dohan.doj.service;


import com.dohan.doj.dto.MemberDto;
import com.dohan.doj.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void join(MemberDto memberDto) {
        validateDuplicateMember(memberDto);
        memberRepository.add(memberDto);
    }

    private void validateDuplicateMember(MemberDto memberDto) {
        memberRepository.findByEmail(memberDto.getEmail())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<MemberDto> findAll() {
        return memberRepository.findAll();
    }

}
