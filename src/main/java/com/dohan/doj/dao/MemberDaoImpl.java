package com.dohan.doj.dao;

import com.dohan.doj.converter.DataConverter;
import com.dohan.doj.dto.MemberDto;
import com.dohan.doj.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class MemberDaoImpl implements MemberDao {

    private final EntityManager entityManager;
    private final DataConverter dataConverter;

    @Autowired
    public MemberDaoImpl(EntityManager entityManager, DataConverter dataConverter) {
        this.entityManager = entityManager;
        this.dataConverter = dataConverter;
    }

    @Override
    public Optional<MemberDto> getById(int id) {
        Member member = entityManager.find(Member.class, id);
        return Optional.ofNullable(dataConverter.convertToDto(member));
    }

    @Override
    public Optional<MemberDto> getByNickname(String nickname) {
        String jpql = "select m from Member as m where m.nickname = :nickname";
        List<Member> result = entityManager.createQuery(jpql, Member.class)
                .setParameter("nickname", nickname)
                .getResultList();
        Member member = result.stream().findAny().orElse(null);
        return Optional.ofNullable(dataConverter.convertToDto(member));
    }

    @Override
    public Optional<MemberDto> getByEmail(String email) {
        String jpql = "select m from Member as m where m.email = :email";
        List<Member> result = entityManager.createQuery(jpql, Member.class)
                .setParameter("email", email)
                .getResultList();
        Member member = result.stream().findAny().orElse(null);
        return Optional.ofNullable(dataConverter.convertToDto(member));
    }

    @Override
    public List<MemberDto> getAll() {
        String jpql = "select m from Member m";
        List<Member> result = entityManager.createQuery(jpql, Member.class).getResultList();
        // Object로 업 캐스팅 안 하면 형변환이 안 됨.
        return (List<MemberDto>)(Object)result.stream().map(member -> dataConverter.convertToDto(member)).collect(Collectors.toList());
    }
    @Override
    public void create(MemberDto memberDto) {
        entityManager.persist(dataConverter.convertToEntity(memberDto));
    }

    @Override
    public void update(MemberDto memberDto) {
        entityManager.merge(dataConverter.convertToEntity(memberDto));
    }

    @Override
    public void remove(MemberDto memberDto) {
        entityManager.remove(dataConverter.convertToEntity(memberDto));
    }
}
