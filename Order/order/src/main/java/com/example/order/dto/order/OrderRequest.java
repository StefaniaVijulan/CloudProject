package com.example.order.dto.order;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.JoinColumn;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Getter
@Setter
public class OrderRequest {

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateOrder;

    private Double priceOrder;

    @NotNull(message = "Price cannot be null")
    private Double taxPriceOrder;

    @NotNull
    private Double totalPriceOrder;

    @NotNull(message = "Voucher cannot be null")
    private Double voucherOrder;


    @NotNull(message = "You need a list of products ")
    private List<Integer> productIds = new ArrayList<>();

}
