package com.example.order.service.order;

import com.example.order.dto.order.OrderRequest;
import com.example.order.dto.order.OrderResponse;
import com.example.order.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderServiceInt {

    public OrderResponse addOrder(OrderRequest order, Integer idUser);
    public OrderResponse editOrder(OrderRequest order, Integer idOrder);
    public String deleteOrder(Integer idOrder);
    public List<Order> orderList();
}
