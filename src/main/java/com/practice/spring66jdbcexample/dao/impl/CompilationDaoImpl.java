package com.practice.spring66jdbcexample.dao.impl;

import com.practice.spring66jdbcexample.dao.CompilationDao;
import com.practice.spring66jdbcexample.model.Category;
import com.practice.spring66jdbcexample.model.Compilation;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class CompilationDaoImpl implements CompilationDao {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Compilation> findAll() {
        return List.of();
    }

    @Override
    public Compilation findById(int id) {
        return null;
    }

    @Override
    @Transactional
    public Compilation create(Compilation compilation) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("compilations")
                .usingGeneratedKeyColumns("id");

        Map<String, Object> map = new HashMap<>();
        map.put("name", compilation.getName());

        int id = insert.executeAndReturnKey(map).intValue();
        compilation.setId(id);
        String sql = "insert into compilations_products (product_id, compilation_id) values (?, ?)";
        jdbcTemplate.batchUpdate(sql, compilation.getProducts(), compilation.getProducts().size(),
                (ps, productId) -> {
                    ps.setInt(1, productId);
                    ps.setInt(2, compilation.getId());
                }
        );

        return compilation;
    }

    @Override
    public void create10_000() {
        List<String> compilations = Collections.nCopies(10_000, "Подборка#");

        LocalDateTime start = LocalDateTime.now();
        for (String compilationName : compilations) {
            String sql = "insert into compilations (name) values (?)";
            jdbcTemplate.update(sql, compilationName);
        }
        LocalDateTime end = LocalDateTime.now();

        Duration duration = Duration.between(start, end);
        System.out.println(duration.toMillis());
    }

    @Override
    public void create10_000Batch() {
        List<String> compilations = Collections.nCopies(10_000, "Подборка#");

        LocalDateTime start = LocalDateTime.now();
        String sql = "insert into compilations (name) values (?)";
        jdbcTemplate.batchUpdate(sql, compilations, compilations.size(),
                (ps, compilationName) -> ps.setString(1, compilationName)
        );
        LocalDateTime end = LocalDateTime.now();

        Duration duration = Duration.between(start, end);
        System.out.println(duration.toMillis());
    }
}
