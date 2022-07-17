package kau.isabu.web_project.discount;

import kau.isabu.web_project.member.Member;

public interface DiscountPolicy {
    /*
    return 할인 대상 금액
     */
    int discount(Member mem,int price);

}
