package com.example.product.dto.product;


import com.example.product.model.Category;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Getter
@Setter
public class ProductRequest {
    @NotNull(message = "Title cannot be null")
    @NotEmpty(message = "Title cannot be empty")
    private String titleProduct;

    @NotNull(message = "Price cannot be null")
    private Double priceProduct;

    private String descriptionProduct;


    public ProductRequest(String titleProduct, Double priceProduct, String descriptionProduct) {
        this.titleProduct = titleProduct;
        this.priceProduct = priceProduct;
        this.descriptionProduct = descriptionProduct;
    }

    public ProductRequest() {
    }
}
