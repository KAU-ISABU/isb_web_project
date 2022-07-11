package kau.isabu.web_project;

import kau.isabu.web_project.repository.JdbcMemberReposity;
import kau.isabu.web_project.repository.MemorymemberRepository;
import kau.isabu.web_project.repository.memberRepository;
import kau.isabu.web_project.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceUtils;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(MemberRepository());
    }

    @Bean
    public memberRepository MemberRepository(){
        return new JdbcMemberReposity(dataSource);
    }
}
