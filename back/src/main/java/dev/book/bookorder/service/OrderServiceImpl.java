package dev.book.bookorder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.book.bookorder.model.dto.OrderDTO;
import dev.book.bookorder.model.entity.Book;
import dev.book.bookorder.model.entity.Order;
import dev.book.bookorder.repository.BookRepository;
import dev.book.bookorder.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
    
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    BookRepository bookRepository;

    @Override
    public void insertOrder(OrderDTO orderDTO) {
        Book book = bookRepository.findByName(orderDTO.getBookTitle());

        // Order 엔티티 생성
        Order order = new Order();
        order.setUserName(orderDTO.getUserName());
        order.setAddress(orderDTO.getAdders());
        order.setTotalPrice(orderDTO.getTotalPrice());

        // 연관관계 설정(맵핑), 주문 테이블에 넣기
        order.setBook(book);

        // 저장
        orderRepository.save(order);
    }
}
