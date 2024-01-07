package com.example.order.dto.order;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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

    @Min(value = 5, message = "Min quantity should be at least 5")
    private Double totalPriceOrder;

    @NotNull(message = "Voucher cannot be null")
    private Double voucherOrder;

}
