package kau.isabu.web_project.repository;
import kau.isabu.web_project.domain.member;

import java.util.List;
import java.util.Optional;

public interface memberRepository {
    member save(member mem);
    Optional<member> findById(Long id);
    Optional<member> findByName(String name);
    List<member> findAll();
}
