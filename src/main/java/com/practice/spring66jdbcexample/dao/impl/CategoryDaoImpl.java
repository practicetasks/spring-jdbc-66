package com.practice.spring66jdbcexample.dao.impl;

import com.practice.spring66jdbcexample.dao.CategoryDao;
import com.practice.spring66jdbcexample.model.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Component
@RequiredArgsConstructor
public class CategoryDaoImpl implements CategoryDao {
    private final JdbcTemplate jdbcTemplate;

    // query - select
    // update - insert/update/delete

    @Override
    public List<Category> findAll() {
        String sql = "select * from categories";
//        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sql);
//
//        List<Category> categories = new ArrayList<>();
//        while (sqlRowSet.next()) {
//            int id = sqlRowSet.getInt("id");
//            String name = sqlRowSet.getString("name");
//            Category category = new Category(id, name);
//            categories.add(category);
//        }
//
//        return categories;

//        RowMapper<Category> rowMapper = (ResultSet rs, int rowNum) -> mapRow(rs, rowNum);
//        RowMapper<Category> rowMapper = this::mapRow;

        return jdbcTemplate.query(sql, this::mapRow);
    }

    @Override
    public Category findById(int id) { // select * from categories where id = ?
        String sql = "select * from categories where id = ?";
        return jdbcTemplate.query(sql, this::mapRow, id)
                .stream()
                .findFirst()
                .orElseThrow();
    }

    @Override
    public Category create(Category category) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("categories")      // указываем название таблицы
                .usingGeneratedKeyColumns("id");  // указываем название колонки который будет генерится

        Map<String, Object> map = new HashMap<>();
        map.put("name", category.getName());

        int id = insert.executeAndReturnKey(map).intValue();
        category.setId(id);

        return category;
    }

    @Override
    public Category update(Category category) {  // update categories set name = ? where id = ?
        return null;
    }

    @Override
    public void deleteById(int id) {  // delete from categories where id = ?

    }

    private Category mapRow(ResultSet rs, int rowNum) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        return new Category(id, name);
    }
}
