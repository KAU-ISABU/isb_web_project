package kau.isabu.web_project.repository;

import kau.isabu.web_project.domain.member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements memberRepository{
    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public member save(member mem) {
        em.persist(mem);
        return mem;
    }

    @Override
    public Optional<member> findById(Long id) {
        member mem = em.find(member.class,id);
        return Optional.ofNullable(mem);
    }

    @Override
    public Optional<member> findByName(String name) {
        return em.createQuery("select m from member m where m.name = :name",member.class)
                .setParameter("name",name)
                .getResultStream().findAny();
    }

    @Override
    public List<member> findAll() {
        return em.createQuery("select m from member m",member.class)
                .getResultList();
    }
}
