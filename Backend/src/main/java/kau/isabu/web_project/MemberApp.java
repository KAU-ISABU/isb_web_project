package kau.isabu.web_project;

import kau.isabu.web_project.member.Grade;
import kau.isabu.web_project.member.Member;
import kau.isabu.web_project.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member mem = new Member(1L,"kyo2011", Grade.VIP);
        memberService.join(mem);
        Member findmem = memberService.findMember(1L);
    }
}
