package kau.isabu.web_project;

import kau.isabu.web_project.discount.DiscountPolicy;
import kau.isabu.web_project.discount.RateDiscountPolicy;
import kau.isabu.web_project.member.MemberRepository;
import kau.isabu.web_project.member.MemberService;
import kau.isabu.web_project.member.MemberServiceImpl;
import kau.isabu.web_project.member.MemoryMemberRepository;
import kau.isabu.web_project.order.OrderService;
import kau.isabu.web_project.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(),discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
}
