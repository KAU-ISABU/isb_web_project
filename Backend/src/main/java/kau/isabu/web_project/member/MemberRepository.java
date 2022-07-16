package kau.isabu.web_project.member;

public interface MemberRepository {
    void save(Member mem);
    Member findById(Long memberId);
}
