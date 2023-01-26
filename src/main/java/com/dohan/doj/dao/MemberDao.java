package com.dohan.doj.dao;

import com.dohan.doj.dto.MemberDto;

import java.util.List;
import java.util.Optional;

public interface MemberDao {
    Optional<MemberDto> getById(int id);
    Optional<MemberDto> getByNickName(String nickName);
    Optional<MemberDto> getByEmail(String email);
    List<MemberDto> getAll();
    void create(MemberDto memberDto);
    void update(MemberDto memberDto);
    void remove(MemberDto memberDto);
}
