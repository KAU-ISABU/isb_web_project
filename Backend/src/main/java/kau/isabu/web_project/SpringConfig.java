package kau.isabu.web_project;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import kau.isabu.web_project.repository.JdbcMemberReposity;
import kau.isabu.web_project.repository.JdbcTemplateMemberRepository;
import kau.isabu.web_project.repository.MemorymemberRepository;
import kau.isabu.web_project.repository.memberRepository;
import kau.isabu.web_project.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceUtils;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private DataSource dataSource;
    @Bean
    public MemberService memberService(){
        return new MemberService(MemberRepository());
    }

    @Bean
    public memberRepository MemberRepository(){
        return new JdbcTemplateMemberRepository(dataSource);
    }
}
