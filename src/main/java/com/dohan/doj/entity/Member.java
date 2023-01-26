package com.dohan.doj.entity;


import com.dohan.doj.constant.MemberRole;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="member")
@Getter
@Setter
public class Member {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키 생성방식. DB에 의존하지 않으려면 AUTO로 하는 방법도 있다.
    private int id;

    @Column(name="nickname")
    private String nickname;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="member_role")
    private MemberRole memberRole;
}
