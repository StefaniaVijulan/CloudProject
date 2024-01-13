package com.example.order.controller;

import com.example.order.dto.order.OrderRequest;
import com.example.order.dto.order.OrderResponse;
import com.example.order.model.Order;
import com.example.order.service.order.OrderServiceInt;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "http://localhost:4200")

public class OrderController {

    private final OrderServiceInt orderServiceInt;

    public OrderController(OrderServiceInt orderServiceInt) {
        this.orderServiceInt = orderServiceInt;
    }


    @PostMapping
    public OrderResponse addOrder(@RequestBody @Valid OrderRequest order, @RequestParam Integer idUser){
        System.out.println("Ajungem aici");
        return orderServiceInt.addOrder(order, idUser);
    }

    @PutMapping
    public OrderResponse editOrder(@RequestBody OrderRequest order, @RequestParam Integer idOrder){
        return  orderServiceInt.editOrder(order, idOrder);
    }

    @DeleteMapping
    public String deleteOrder(@RequestParam Integer idOrder){
        return orderServiceInt.deleteOrder(idOrder);
    }

    @GetMapping
    public List<Order> getAllOrders(){
        return orderServiceInt.orderList();
    }

}
