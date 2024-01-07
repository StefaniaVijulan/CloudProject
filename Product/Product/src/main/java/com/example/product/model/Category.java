package com.example.product.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Category")
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategory;

    @NotNull(message = "The name cannot be null")
    @NotEmpty(message = "The name cannot be empty")
    private String nameCategory;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<Product> productList = new ArrayList<>();

    public Category() {
    }

    public Category(Integer idCategory, String nameCategory, List<Product> productList) {
        this.idCategory = idCategory;
        this.nameCategory = nameCategory;
        this.productList = productList;
    }
}
