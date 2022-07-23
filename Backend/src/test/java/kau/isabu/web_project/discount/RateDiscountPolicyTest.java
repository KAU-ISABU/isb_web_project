package kau.isabu.web_project.discount;

import kau.isabu.web_project.member.Grade;
import kau.isabu.web_project.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    DiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP must discount by 10%")
    void 할인테스트(){
        //given
        Member mem = new Member(1L,"pichulia", Grade.VIP);
        //when
        int dc=rateDiscountPolicy.discount(mem,10000);
        //then
        Assertions.assertThat(dc).isEqualTo(1000);
    }

    @Test
    @DisplayName("Non-Vip must not be discounted")
    void 할인테스트2(){
        //given
        Member mem = new Member(1L,"pichulia", Grade.BASIC);
        //when
        int dc=rateDiscountPolicy.discount(mem,10000);
        //then
        Assertions.assertThat(dc).isEqualTo(1000);
    }

}