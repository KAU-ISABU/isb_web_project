package kau.isabu.web_project.beanfind;

import kau.isabu.web_project.AppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    void 모든빈출력하기(){
        String[] arr = applicationContext.getBeanDefinitionNames();
        for (String s : arr) {
            Object nowbean=applicationContext.getBean(s);
            System.out.println("name "+s+" object "+nowbean.toString());

        }
    }
    @Test
    void 모든빈출력하기2(){
        String[] arr = applicationContext.getBeanDefinitionNames();
        for (String s : arr) {
            BeanDefinition beanDefinition = applicationContext.getBeanDefinition(s);
            if(beanDefinition.getRole() != BeanDefinition.ROLE_APPLICATION) continue;
            Object nowbean=applicationContext.getBean(s);
            System.out.println("name "+s+" object "+nowbean.toString());

        }
    }
}
