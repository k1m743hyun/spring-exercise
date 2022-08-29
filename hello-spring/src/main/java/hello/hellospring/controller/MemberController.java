package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    // 필드 주입
    //@Autowired private MemberService memberService;
    private MemberService memberService;

    // Setter 주입
    //@Autowired
    //public void setMemberService(MemberService memberService) {
    //    this.memberService = memberService;
    //}

    // 생성자 주입
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
        //memberService.setMemberRepository(); // 누구나 호출 가능
    }
}
