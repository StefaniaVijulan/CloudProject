package com.example.product.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import net.bytebuddy.agent.builder.AgentBuilder;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity(name = "Product")
@Setter
@Getter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProduct;

    @NotNull(message = "Title cannot be null")
    @NotEmpty(message = "Title cannot be empty")
    private String titleProduct;

    @NotNull(message = "Price cannot be null")
    private Double priceProduct;

    @NotNull(message = "The description cannot be null")
    private String descriptionProduct;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


    public Product(){}

    public Product(int idProduct, String titleProduct, Double priceProduct, String descriptionProduct, Category category) {
        this.idProduct = idProduct;
        this.titleProduct = titleProduct;
        this.priceProduct = priceProduct;
        this.descriptionProduct = descriptionProduct;
        this.category = category;
    }
}
