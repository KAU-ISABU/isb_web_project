package kau.isabu.web_project.repository;

import kau.isabu.web_project.domain.member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<member,Long>,memberRepository {
    @Override
    Optional<member> findByName(String name);
}
