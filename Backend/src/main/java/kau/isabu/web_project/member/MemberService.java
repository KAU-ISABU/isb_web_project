package kau.isabu.web_project.member;

public interface MemberService {
    void join(Member mem);
    Member findMember(Long memberId);
}
