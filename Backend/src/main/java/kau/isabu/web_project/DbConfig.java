package kau.isabu.web_project;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DbConfig{
        @Bean
        @Primary
        public DataSource dataSource() {
            return DataSourceBuilder
                    .create()
                    .username("postgres")
                    .password("sj7699")
                    .url("jdbc:postgresql://localhost:5432/postgres")
                    .driverClassName("org.postgresql.Driver")
                    .build();
        }
}
