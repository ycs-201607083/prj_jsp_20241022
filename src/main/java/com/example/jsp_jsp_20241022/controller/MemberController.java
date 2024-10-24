package com.example.jsp_jsp_20241022.controller;

import com.example.jsp_jsp_20241022.dto.Member;
import com.example.jsp_jsp_20241022.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("member")
public class MemberController {

    private final MemberService service;

    @GetMapping("signup")
    public void signup() {

    }

    @PostMapping("signup")
    public String signupProcess(Member member, RedirectAttributes rttr) {
        service.addMember(member);
        rttr.addFlashAttribute("m",
                Map.of(
                        "type", "success",
                        "text", "회원가입 되었습니다."));

        return "redirect:/board/list";
    }

    @GetMapping("list")
    public void list(Model model) {
        model.addAttribute("memberList", service.list());
    }

    @GetMapping("view")
    public void info(String id, Model model) {
        Member member = service.info(id);
        model.addAttribute("member", member);
    }

    @PostMapping("delete")
    public String deleteBoard(String id, String password, RedirectAttributes rttr) {


        if (service.remove(id, password)) {
            //탈퇴성공
            rttr.addFlashAttribute("message", Map.of("type", "dark", "text", "회원 목록에서 탈퇴 되었습니다."));
            return "redirect:/member/signup";
        } else {
            //탈퇴실패
            rttr.addFlashAttribute("message", Map.of("type", "danger", "text", "패스워드가 일치하지 않습니다."));
            rttr.addAttribute("id", id);
            return "redirect:/member/view";
        }
    }

    @GetMapping("edit")
    public void view(Member m, Model model) {
        service.update(m);
        model.addAttribute("member", m);
    }

    @PostMapping("edit")
    public String editProcess(Member member, RedirectAttributes rttr) {

        return "redirect:/member/list";
    }
}
