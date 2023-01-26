package com.dohan.doj.dto;

import com.dohan.doj.constant.MemberRole;
import lombok.Data;
import lombok.Getter;

@Data
public class MemberDto {
    private String nickName;
    private String email;
    private String password;
    private MemberRole memberRole;
}
