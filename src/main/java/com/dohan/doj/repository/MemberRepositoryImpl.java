package com.dohan.doj.repository;

import com.dohan.doj.dao.MemberDaoImpl;
import com.dohan.doj.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MemberRepositoryImpl implements MemberRepository {

    private final MemberDaoImpl memberDao;

    @Autowired
    public MemberRepositoryImpl(MemberDaoImpl memberDao) {
        this.memberDao = memberDao;
    }

    @Override
    public Optional<MemberDto> findByNickname(String nickname) {
        return memberDao.getByNickname(nickname);
    }

    @Override
    public Optional<MemberDto> findByEmail(String email) {
        return memberDao.getByEmail(email);
    }

    @Override
    public List<MemberDto> findAll() {
        return memberDao.getAll();
    }

    @Override
    public void add(MemberDto memberDto) {
        memberDao.create(memberDto);
    }

    @Override
    public void update(MemberDto memberDto) {
        memberDao.update(memberDto);
    }

    @Override
    public void remove(MemberDto memberDto) {
        memberDao.remove(memberDto);
    }

}
