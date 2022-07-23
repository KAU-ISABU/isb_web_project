package kau.isabu.web_project.order;

import kau.isabu.web_project.discount.DiscountPolicy;
import kau.isabu.web_project.member.Member;
import kau.isabu.web_project.member.MemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member mem= memberRepository.findById(memberId);
        int discountprice=discountPolicy.discount(mem,itemPrice);
        return new Order(memberId,itemPrice,itemName,discountprice);
    }
}
