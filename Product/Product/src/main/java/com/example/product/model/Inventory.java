package com.example.product.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Getter
@Setter
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idInventory;

    @NotNull(message = "Quantity cannot be null")
    @Min(value = 1,message = "It has to be ore then 1" )
    private Integer quantityProduct;

    @NotNull(message = "Sales cannot be null")
    @Min(value = 1,message = "It has to be more then 1" )
    private Integer salesProduct;


    public Inventory() {
    }

    public Inventory(int idInventory, Integer quantityProduct, Integer salesProduct) {
        this.idInventory = idInventory;
        this.quantityProduct = quantityProduct;
        this.salesProduct = salesProduct;
    }
}
