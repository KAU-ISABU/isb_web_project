package kau.isabu.web_project;

import kau.isabu.web_project.repository.MemorymemberRepository;
import kau.isabu.web_project.repository.memberRepository;
import kau.isabu.web_project.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(MemberRepository());
    }

    @Bean
    public memberRepository MemberRepository(){
        return new MemorymemberRepository();
    }
}
