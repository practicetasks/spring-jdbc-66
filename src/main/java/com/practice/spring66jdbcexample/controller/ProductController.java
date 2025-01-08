package com.practice.spring66jdbcexample.controller;

import com.practice.spring66jdbcexample.dao.ProductDao;
import com.practice.spring66jdbcexample.model.Category;
import com.practice.spring66jdbcexample.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor // конструктор для всех финальных полей
@RequestMapping("/products")
public class ProductController {
    private final ProductDao productDao;

    @GetMapping
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable int id) {
        return productDao.findById(id);
    }
}
