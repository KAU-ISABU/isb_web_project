package kau.isabu.web_project.service;

import kau.isabu.web_project.domain.member;
import kau.isabu.web_project.repository.MemorymemberRepository;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MemberService memberService;
    MemorymemberRepository memorymemberRepository;
    @BeforeEach
    public void beforeEach(){
        memorymemberRepository = new MemorymemberRepository();
        memberService=new MemberService(memorymemberRepository);
    }
    @AfterEach
    public void afterEach(){
        memorymemberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        //given 뭔가 주어졌을떄
        member  Member = new member();
        Member.setName("koosaga");
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
        Member1.setName("koosaga");

        member Member2 = new member();
        Member2.setName("koosaga");
        //when
        memberService.join(Member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(Member2));
        Assertions.assertThat(e.getMessage()).isEqualTo(("이미 존재하는 회원입니다"));
        /*try {
            memberService.join(Member2);
            fail("예외가 발생해야 합니다");
        }catch(IllegalStateException e){
            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");
        }*/
        //then
    }
    @Test
    void 전체멤버찾기() {
    }

    @Test
    void 멤버찾기() {
    }
}