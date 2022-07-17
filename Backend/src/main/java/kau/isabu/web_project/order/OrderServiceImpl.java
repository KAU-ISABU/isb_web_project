package kau.isabu.web_project.order;

import kau.isabu.web_project.discount.DiscountPolicy;
import kau.isabu.web_project.discount.FixDiscountPolicy;
import kau.isabu.web_project.member.Member;
import kau.isabu.web_project.member.MemberRepository;
import kau.isabu.web_project.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member mem= memberRepository.findById(memberId);
        int discountprice=discountPolicy.discount(mem,itemPrice);
        return new Order(memberId,itemPrice,itemName,discountprice);
    }
}
