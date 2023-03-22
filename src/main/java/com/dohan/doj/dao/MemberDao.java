package com.dohan.doj.dao;

import com.dohan.doj.dto.MemberDto;

import java.util.List;
import java.util.Optional;

// DB가 바뀔 수도 있으니 인터페이스로 생성
public interface MemberDao {
    Optional<MemberDto> getById(int id);
    Optional<MemberDto> getByNickname(String nickname);
    Optional<MemberDto> getByEmail(String email);
    List<MemberDto> getAll();
    void create(MemberDto memberDto);
    void update(MemberDto memberDto);
    void remove(MemberDto memberDto);
}
