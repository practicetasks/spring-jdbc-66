package com.practice.spring66jdbcexample.dao;

import com.practice.spring66jdbcexample.model.Category;

import java.util.List;

public interface CategoryDao {
    List<Category> findAll();

    Category findById(int id);

    Category create(Category category);

    Category update(Category category);

    void deleteById(int id);
}
