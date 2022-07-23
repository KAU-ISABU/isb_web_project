package kau.isabu.web_project;

import kau.isabu.web_project.member.Grade;
import kau.isabu.web_project.member.Member;
import kau.isabu.web_project.member.MemberService;
import kau.isabu.web_project.member.MemberServiceImpl;
import kau.isabu.web_project.order.Order;
import kau.isabu.web_project.order.OrderService;
import kau.isabu.web_project.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;
    @BeforeEach
    public void createAppConfig(){
        AppConfig appConfig = new AppConfig();
        memberService=appConfig.memberService();
        orderService=appConfig.orderService();
    }
    @Test
    void 주문(){
        Long memberId = 1L;
        Member member = new Member(memberId,"koosaga", Grade.VIP);
        memberService.join(member);
        Order order=orderService.createOrder(memberId,"itemA",10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
