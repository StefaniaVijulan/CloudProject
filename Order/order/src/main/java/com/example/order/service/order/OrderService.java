package com.example.order.service.order;


import com.example.order.dto.order.OrderRequest;
import com.example.order.dto.order.OrderResponse;
import com.example.order.exception.Custom;
import com.example.order.model.Order;
import com.example.order.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class OrderService implements OrderServiceInt{

    @Autowired
    OrderRepository orderRepository;

//    @Autowired

    @Override
    public OrderResponse addOrder(OrderRequest order, Integer idUser){

        Order order1 = new Order();

        order1.setDateOrder(order.getDateOrder());
        order1.setVoucherOrder(order.getVoucherOrder());
        order1.setPriceOrder(order.getPriceOrder());
        order1.setTaxPriceOrder(order.getTaxPriceOrder());
        order1.setTotalPriceOrder(order.getTotalPriceOrder());
        order1.setIdUser(idUser);
        orderRepository.save(order1);

//        order.setProducts(productList);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setDateOrder(order1.getDateOrder());
        orderResponse.setTotalPriceOrder(order1.getTotalPriceOrder());

        log.info("Order of. " + order.getTotalPriceOrder() + " was successfully added" );
        return orderResponse;
    }

    @Override
    public OrderResponse editOrder(OrderRequest order, Integer idOrder){
        Order order1 = orderRepository.findById(idOrder).orElseThrow(
                () -> new Custom("Order with this id is not found"));
        order1.setVoucherOrder(order.getVoucherOrder());
        order1.setDateOrder(order.getDateOrder());
        order1.setPriceOrder(order.getPriceOrder());
        order1.setTaxPriceOrder(order.getTaxPriceOrder());
        order1.setTotalPriceOrder(order.getTotalPriceOrder());

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setDateOrder(order1.getDateOrder());
        orderResponse.setTotalPriceOrder(order1.getTotalPriceOrder());

        orderRepository.save(order1);
        return orderResponse;
    }

    @Override
    public String deleteOrder(Integer idOrder){
        Order order1 = orderRepository.findById(idOrder).orElseThrow(
                () -> new RuntimeException("Order with this id is not found"));
        orderRepository.delete(order1);
        return "The order was successfully delete";
    }

    @Override
    public List<Order> orderList(){
        return  orderRepository.findAll();
    }

//    public List<Order> userOrderList(Integer idUser) {
//        List<Order> orderList = orderList();
//        List<Order> userOrderList = new ArrayList<>();
//        System.out.println(orderList);
//        for(int i=0; i<orderList.size(); i++){
//            if(orderList().get(i).getIdOrder() == idUser ){
//                userOrderList.add(orderList().get(i));
//            }
//        }
//    }
}
