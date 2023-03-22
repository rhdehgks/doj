package com.dohan.doj.dto;

import com.dohan.doj.constant.MemberRole;
import lombok.Data;

@Data
public class MemberDto {
    private String nickname;
    private String email;
    private String password;
    private MemberRole memberRole;
}
