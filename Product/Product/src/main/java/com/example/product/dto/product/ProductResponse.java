package com.example.product.dto.product;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@RequiredArgsConstructor
@Data
@Getter
@Setter
public class ProductResponse {
    @NotNull(message = "Title cannot be null")
    @NotEmpty(message = "Title cannot be empty")
    private String titleProduct;

    @NotNull(message = "Price cannot be null")
    private Double priceProduct;

    @NotNull(message = "Description cannot be null")
    private String descriptionProduct;


}
