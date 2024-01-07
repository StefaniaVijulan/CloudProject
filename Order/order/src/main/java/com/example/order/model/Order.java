package com.example.order.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "Order")
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOrder;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateOrder;

    private Double priceOrder;

    @NotNull(message = "Price cannot be null")
    private Double taxPriceOrder;

    @Min(value = 5, message = "Min quantity should be at least 5")
    private Double totalPriceOrder;

    @NotNull(message = "Voucher cannot be null")
    private Double voucherOrder;

    @NotNull(message = "IdUser can not be null")
    private int idUser;

    public Order() {
    }

    public Order(int idOrder, Date dateOrder, Double priceOrder, Double taxPriceOrder, Double totalPriceOrder, Double voucherOrder, int idUser) {
        this.idOrder = idOrder;
        this.dateOrder = dateOrder;
        this.priceOrder = priceOrder;
        this.taxPriceOrder = taxPriceOrder;
        this.totalPriceOrder = totalPriceOrder;
        this.voucherOrder = voucherOrder;
        this.idUser = idUser;
    }
}

