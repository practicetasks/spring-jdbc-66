package com.practice.spring66jdbcexample.controller;

import com.practice.spring66jdbcexample.dao.CategoryDao;
import com.practice.spring66jdbcexample.model.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor // конструктор для всех финальных полей
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryDao categoryDao;

    @GetMapping
    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable int id) {
        return categoryDao.findById(id);
    }

    @PostMapping
    public Category create(@RequestBody Category category) {
        return categoryDao.create(category);
    }

    @PutMapping
    public Category update(@RequestBody Category category) {
        return categoryDao.update(category);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        categoryDao.deleteById(id);
    }
}
