package com.example.product.dto.inventory;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Getter
@Setter
public class InventoryResponse {

    @NotNull(message = "Quantity cannot be null")
    @Min(value = 1,message = "It has to be ore then 1" )
    private Integer quantityProduct;

    @NotNull(message = "Sales cannot be null")
    @Min(value = 1,message = "It has to be more then 1" )
    private Integer salesProduct;

    public InventoryResponse(Integer quantityProduct, Integer salesProduct) {
        this.quantityProduct = quantityProduct;
        this.salesProduct = salesProduct;
    }

    public InventoryResponse() {
    }
}
