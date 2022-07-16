package kau.isabu.web_project.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{
    private static Map<Long,Member> store=new HashMap<>();

    @Override
    public void save(Member mem) {
        store.put(mem.getId(),mem);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
