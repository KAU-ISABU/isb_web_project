package kau.isabu.web_project.repository;

import kau.isabu.web_project.domain.member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class JdbcTemplateMemberRepository implements memberRepository{
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcTemplateMemberRepository(DataSource datasource) {
        this.jdbcTemplate = new JdbcTemplate(datasource);
    }

    @Override
    public member save(member mem) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("member").usingGeneratedKeyColumns("id");
        Map<String,Object> param = new HashMap<>();
        param.put("name",mem.getName());
        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(param));
        mem.setId(key.longValue());
        return mem;
    }

    @Override
    public Optional<member> findById(Long id) {
        List<member> result= jdbcTemplate.query("select * from member where id = ?",memberRowMapper(),id);
        return result.stream().findAny();//Optional로 반환
    }

    @Override
    public Optional<member> findByName(String name) {
        List<member> result= jdbcTemplate.query("select * from member where name = ?",memberRowMapper(),name);
        return result.stream().findAny();//Optional로 반환
    }

    @Override
    public List<member> findAll() {
        List<member> result= jdbcTemplate.query("select * from member",memberRowMapper());
        return result;//Optional로 반환
    }
    private RowMapper<member> memberRowMapper(){
        return (rs1, rowNum1) -> {
            member Member = new member();
            Member.setId(rs1.getLong("id"));
            Member.setName(rs1.getString("name"));
            return Member;
        };
    }
}
