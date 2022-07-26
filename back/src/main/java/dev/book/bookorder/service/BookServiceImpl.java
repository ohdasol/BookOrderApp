package dev.book.bookorder.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.book.bookorder.model.dto.BookDTO;
import dev.book.bookorder.model.entity.Book;
import dev.book.bookorder.repository.BookRepository;

@Service // @Component
public class BookServiceImpl implements BookService {

    @Autowired // 초기값, 빈 등록 spring이 알아서 해줌
    private BookRepository bookRepository;

    @Override
    public List<BookDTO> findAllBooks() {
        List<Book> list = bookRepository.findAll(); // Entity 타입인 List<Book>을 반환, JPA 활용 부분(em.find())
        System.out.println("findAll() list : " + list);
        List<BookDTO> result = list.stream().map(r -> new BookDTO(r)).collect(Collectors.toList()); // Book Entity 요소를 DTO 타입으로 변경
        return result;
    }
    
}
