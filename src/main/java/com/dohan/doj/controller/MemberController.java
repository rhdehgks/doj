package com.dohan.doj.controller;

import com.dohan.doj.constant.MemberRole;
import com.dohan.doj.dto.MemberDto;
import com.dohan.doj.service.MemberServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberServiceImpl memberService;

    public MemberController(MemberServiceImpl memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/register")
    public String createRegisterForm() {
        return "member/register";
    }
    @PostMapping("/register.action")
    public String registerMember(@ModelAttribute("memberDto")MemberDto memberDto) {
        memberDto.setMemberRole(MemberRole.USER);
        System.out.println(memberDto.toString());
        memberService.join(memberDto);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String shorMemberList(Model model) {
        List<MemberDto> members = memberService.findAll();
        model.addAttribute("members", members);
        System.out.println(members.size());
        return "/member/memberList";
    }
}
