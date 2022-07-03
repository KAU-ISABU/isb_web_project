package kau.isabu.web_project.repository;

import kau.isabu.web_project.domain.member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MemorymemberRepositorytest {
    MemorymemberRepository repository= new MemorymemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }
    @Test
    public void save(){
        member Member = new member();
        Member.setName("이상재");
        repository.save(Member);
        member result = repository.findById(Member.getId()).get();
        assertThat(Member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        member Member = new member();
        Member.setName("tourist");
        repository.save(Member);


        member Member2 = new member();
        Member2.setName("koosaga");
        repository.save(Member2);

        member result=repository.findByName("tourist").get();
        assertThat(result).isEqualTo(Member);
    }

    @Test void findAll(){
        member Member = new member();
        Member.setName("tourist");
        member Member2 = new member();
        Member2.setName("koosaga");
        repository.save(Member);
        repository.save(Member2);
        List<member> mlist = repository.findAll();
        assertThat(mlist.size()).isEqualTo(2);
    }
}
