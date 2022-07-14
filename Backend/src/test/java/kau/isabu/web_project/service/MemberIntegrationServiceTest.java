package kau.isabu.web_project.service;

import kau.isabu.web_project.domain.member;
import kau.isabu.web_project.repository.MemorymemberRepository;
import kau.isabu.web_project.repository.memberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class MemberIntegrationServiceTest {
    @Autowired  MemberService memberService;
    @Autowired memberRepository MemberRepository;

    @Test
    void 회원가입() {
        //given 뭔가 주어졌을떄
        member  Member = new member();
        Member.setName("benq");
        //when 뭔가를 하면
        Long saveId = memberService.join(Member);
        //then 뭔가가 된다
        member findnumber = memberService.findOne(saveId).get();
        Assertions.assertThat(Member.getName()).isEqualTo(findnumber.getName());
    }

    @Test
    public void dup_member_check(){
        //given
        member Member1 = new member();
        Member1.setName("tourist");

        member Member2 = new member();
        Member2.setName("tourist");
        //when
        memberService.join(Member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(Member2));
        Assertions.assertThat(e.getMessage()).isEqualTo(("이미 존재하는 회원입니다"));
    }
}