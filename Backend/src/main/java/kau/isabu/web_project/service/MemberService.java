package kau.isabu.web_project.service;

import kau.isabu.web_project.domain.member;
import kau.isabu.web_project.repository.MemorymemberRepository;
import kau.isabu.web_project.repository.memberRepository;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;
import java.util.List;
import java.util.Optional;

public class MemberService {
    private final memberRepository MemberRepository;

    public MemberService(memberRepository memberRepository) {
        MemberRepository = memberRepository;
    }

    public Long join(member Member){
        validateDuplicateMember(Member);
        MemberRepository.save(Member);
        return Member.getId();
    }

    private void validateDuplicateMember(member Member) {
        MemberRepository.findByName(Member.getName()).ifPresent(m->{
            throw new IllegalStateException("이미 존재하는 회원입니다");
        });
    }
    public List<member> findMembers(){
        return MemberRepository.findAll();
    }

    public Optional<member> findOne(Long memberId){
        return MemberRepository.findById(memberId);
    }
}
