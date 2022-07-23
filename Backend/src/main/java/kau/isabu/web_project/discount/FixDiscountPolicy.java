package kau.isabu.web_project.discount;

import kau.isabu.web_project.member.Grade;
import kau.isabu.web_project.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{
    private static int discountFixAmount =1000;
    @Override
    public int discount(Member mem, int price) {
        if(mem.getGrade()== Grade.VIP){
            return discountFixAmount;
        }
        else return 0;
    }
}
