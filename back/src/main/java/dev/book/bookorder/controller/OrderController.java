package dev.book.bookorder.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.book.bookorder.model.dto.OrderDTO;
import dev.book.bookorder.service.OrderService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping() // POST : ~/api/v1/orders 주문 테이블에 데이터 추가해서 요청
    public void insertOrder(@RequestBody OrderDTO OrderDTO) { //Cart의 객체들이 OrderDTO의 형태가 같기 때문에 생성
        // System.out.println(OrderDTO);
        // service -> repository -> DB
        orderService.insertOrder(OrderDTO);
    }
}
