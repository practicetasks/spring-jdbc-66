package com.practice.spring66jdbcexample.controller;

import com.practice.spring66jdbcexample.dao.CompilationDao;
import com.practice.spring66jdbcexample.model.Category;
import com.practice.spring66jdbcexample.model.Compilation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor // конструктор для всех финальных полей
@RequestMapping("/compilations")
public class CompilationController {
    private final CompilationDao compilationDao;

    @GetMapping
    public List<Compilation> findAll() {
        return compilationDao.findAll();
    }

    @GetMapping("/{id}")
    public Compilation findById(@PathVariable int id) {
        return compilationDao.findById(id);
    }

    @PostMapping
    public Compilation create(@RequestBody Compilation compilation) {
        return compilationDao.create(compilation);
    }

    @GetMapping("/create10-000")
    public void create10_000() {
        compilationDao.create10_000(); // 693
    }

    @GetMapping("/create10-000batch")
    public void create10_000batch() {
        compilationDao.create10_000Batch(); // 118
    }
}
