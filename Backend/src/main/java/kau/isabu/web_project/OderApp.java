package kau.isabu.web_project;

import kau.isabu.web_project.member.Grade;
import kau.isabu.web_project.member.Member;
import kau.isabu.web_project.member.MemberService;
import kau.isabu.web_project.member.MemberServiceImpl;
import kau.isabu.web_project.order.Order;
import kau.isabu.web_project.order.OrderService;
import kau.isabu.web_project.order.OrderServiceImpl;

public class OderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId=1L;
        Member mem = new Member(memberId,"Koosaga", Grade.VIP);
        memberService.join(mem);

        Order order=orderService.createOrder(memberId,"itemA",10000);
        System.out.println("order = " + order);
        System.out.println("order.calculatePrice() = " + order.calculatePrice());
    }
}
