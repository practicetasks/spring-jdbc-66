package com.practice.spring66jdbcexample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor // конструктор для всех полей
@NoArgsConstructor  // конструктор по умолчанию
public class Category {
    private int id;
    private String name;
}
