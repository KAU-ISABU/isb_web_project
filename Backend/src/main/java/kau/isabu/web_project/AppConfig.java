package kau.isabu.web_project;

import kau.isabu.web_project.discount.DiscountPolicy;
import kau.isabu.web_project.discount.RateDiscountPolicy;
import kau.isabu.web_project.member.MemberRepository;
import kau.isabu.web_project.member.MemberService;
import kau.isabu.web_project.member.MemberServiceImpl;
import kau.isabu.web_project.member.MemoryMemberRepository;
import kau.isabu.web_project.order.OrderService;
import kau.isabu.web_project.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(),discountPolicy());
    }
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
}
