package com.practice.spring66jdbcexample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Compilation {
    private int id;
    private String name;
    private Set<Integer> products; // идентификаторы товаров
}
