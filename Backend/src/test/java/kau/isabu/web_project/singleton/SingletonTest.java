package kau.isabu.web_project.singleton;

import kau.isabu.web_project.AppConfig;
import kau.isabu.web_project.member.Member;
import kau.isabu.web_project.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class SingletonTest {
    @Test
    void 순수DI컨테이너(){
        AppConfig appConfig = new AppConfig();
        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();
        Assertions.assertThat(memberService1).isEqualTo(memberService2);
    }
}
