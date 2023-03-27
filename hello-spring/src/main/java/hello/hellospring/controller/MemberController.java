package hello.hellospring.controller;


import hello.hellospring.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired
    // memberService를 연결시켜줌 container가
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}