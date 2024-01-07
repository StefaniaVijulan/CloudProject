package com.example.order.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Recorder")
@Getter
@Setter
public class Recorder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRecorder;


    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateRecorded;


    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateExpected;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public Recorder(Integer idRecorder, Date dateRecorded, Date dateExpected, Order order) {
        this.idRecorder = idRecorder;
        this.dateRecorded = dateRecorded;
        this.dateExpected = dateExpected;
        this.order = order;
    }

    public Recorder() {

    }


}
