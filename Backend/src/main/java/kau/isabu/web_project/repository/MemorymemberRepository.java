package kau.isabu.web_project.repository;

import kau.isabu.web_project.domain.member;

import java.util.*;

public class MemorymemberRepository implements  memberRepository{
    private static Map<Long, member> store = new HashMap<>();
    private static long sequence = 0L;
    @Override
    public member save(member mem) {
        mem.setId(++sequence);
        store.put(mem.getId(),mem);
        return mem;
    }

    @Override
    public Optional<member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<member> findByName(String name) {
        return store.values().stream()
                .filter(Member-> Member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
