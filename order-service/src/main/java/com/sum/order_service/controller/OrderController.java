package com.sum.order_service.controller;

import com.sum.order_service.dto.OrderLineItemsDto;
import com.sum.order_service.dto.OrderRequest;
import com.sum.order_service.model.Order;
import com.sum.order_service.repository.OrderRepository;
import com.sum.order_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private final OrderRepository orderRepository;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest){
        orderService.placeOrder(orderRequest);
            return "order placed successfully";
    }

    @GetMapping("/{orderNumber}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Order>> getOrderDetails(@PathVariable(value ="orderNumber")String skuCode){
       List<Order> orderList = orderRepository.findByOrderNumber(skuCode);
       if(orderList==null){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
       return new ResponseEntity<>(orderList,HttpStatus.OK);

    }



}
