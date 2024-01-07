package com.example.order.dto.recorder;

import com.example.order.model.Order;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Date;

@Data
@Getter
@Setter
public class RecorderRequest {

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateRecorded;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateExpected;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public RecorderRequest(Date dateRecorded, Date dateExpected, Order order) {
        this.dateRecorded = dateRecorded;
        this.dateExpected = dateExpected;
        this.order = order;
    }

    public RecorderRequest() {
    }
}
