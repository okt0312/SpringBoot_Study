package hello.hellospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import hello.hellospring.service.MemberService;

@Controller
public class MemberContoller
{
    private final MemberService memberService;

    @Autowired
    public MemberContoller(MemberService memberService)
    {
        super();
        this.memberService = memberService;
    }
    
    
}
