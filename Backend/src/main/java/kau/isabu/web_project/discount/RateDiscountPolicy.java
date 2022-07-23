package kau.isabu.web_project.discount;

import kau.isabu.web_project.member.Grade;
import kau.isabu.web_project.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{
    private int discountPercent = 15;
    @Override
    public int discount(Member mem, int price) {
        if(mem.getGrade()== Grade.VIP){
            return price* discountPercent /100;
        }
        else return 0;
    }
}
