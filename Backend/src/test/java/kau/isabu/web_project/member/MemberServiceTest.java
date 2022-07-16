package kau.isabu.web_project.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();
    @Test
    void join(){
        //give
        //MemberRepository memberRepository = new MemoryMemberRepository();
        Member mem = new Member(1L,"memberA",Grade.VIP);

        //when
        memberService.join(mem);

        //then
        Member mem1=memberService.findMember(1L);
        Assertions.assertThat(mem).isEqualTo(mem1);
    }
}
