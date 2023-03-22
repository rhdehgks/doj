package com.dohan.doj.repository;

import com.dohan.doj.dto.MemberDto;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    //Optional<MemberDto> findById(int id);
    Optional<MemberDto> findByNickname(String nickname);
    Optional<MemberDto> findByEmail(String email);
    List<MemberDto> findAll();
    void add(MemberDto memberDto);
    void update(MemberDto memberDto);
    void remove(MemberDto memberDto);
}
