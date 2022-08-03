package kau.isabu.web_project.beanfind;

import kau.isabu.web_project.AppConfig;
import kau.isabu.web_project.member.MemberService;
import kau.isabu.web_project.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
}
