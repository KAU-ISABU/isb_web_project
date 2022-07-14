package kau.isabu.web_project;

import kau.isabu.web_project.repository.*;
import kau.isabu.web_project.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private EntityManager em;


    private final memberRepository MemberRepository;

    @Autowired
    public SpringConfig(memberRepository memberRepository) {
        this.MemberRepository = memberRepository;
    }

    private DataSource dataSource;
    @Bean
    public MemberService memberService(){
        return new MemberService(MemberRepository);
    }

    @Bean
    public memberRepository MemberRepository(){
        return new JpaMemberRepository(em);
    }
}
