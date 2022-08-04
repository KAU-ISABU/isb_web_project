package kau.isabu.web_project.beanfind;

import kau.isabu.web_project.AppConfig;
import kau.isabu.web_project.discount.DiscountPolicy;
import kau.isabu.web_project.discount.FixDiscountPolicy;
import kau.isabu.web_project.discount.RateDiscountPolicy;
import kau.isabu.web_project.member.MemberService;
import kau.isabu.web_project.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    void 빈이름으로조회(){
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
    @Test
    void 타입으로조회(){
        MemberService memberService = applicationContext.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
    @Test
    void 구체타입으로조회(){
        MemberServiceImpl memberService = applicationContext.getBean("memberService",MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
    @Test
    void 빈이름으로조회실패(){
        org.junit.jupiter.api.Assertions.assertThrows(NoSuchBeanDefinitionException.class,()->applicationContext.getBean("tt", MemberService.class));
    }
    @Test
    void 중복타입빈오류(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SameBeanConfig.class);
        org.junit.jupiter.api.Assertions.assertThrows(NoUniqueBeanDefinitionException.class,()->annotationConfigApplicationContext.getBean(DiscountPolicy.class));
    }
    @Configuration
    static class SameBeanConfig{
        @Bean
        public DiscountPolicy discountPolicy()
        {
            return new RateDiscountPolicy();
        }
        @Bean
        public DiscountPolicy discountPolicy2()
        {
            return new FixDiscountPolicy();
        }
    }

    @Test
    void 특정타입모두조회() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SameBeanConfig.class);
        Map<String, DiscountPolicy> beansOfType = annotationConfigApplicationContext.getBeansOfType(DiscountPolicy.class);
        for(String s : beansOfType.keySet()){
            DiscountPolicy now_bean = annotationConfigApplicationContext.getBean(s, DiscountPolicy.class);
            assertThat(now_bean).isInstanceOf(DiscountPolicy.class);
        }
    }
}
