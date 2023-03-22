package com.dohan.doj.service;

import com.dohan.doj.dto.MemberDto;

import java.util.List;

public interface MemberService {

    void join(MemberDto memberDto);
    void validateDuplicateMember(MemberDto memberDto);
    List<MemberDto> findAll();

}
