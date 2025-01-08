package com.practice.spring66jdbcexample.dao;

import com.practice.spring66jdbcexample.model.Category;
import com.practice.spring66jdbcexample.model.Compilation;

import java.util.List;

public interface CompilationDao {
    List<Compilation> findAll();

    Compilation findById(int id);

    Compilation create(Compilation compilation);

    void create10_000();

    void create10_000Batch();
}
