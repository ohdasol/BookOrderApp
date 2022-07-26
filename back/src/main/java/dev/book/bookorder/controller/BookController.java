package dev.book.bookorder.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.book.bookorder.model.dto.BookDTO;
import dev.book.bookorder.service.BookService;

@CrossOrigin(origins = "*") // 모든 요청을 받음
@RestController // @Controller + @ResponseBody
// @Controller : @Component가 각 클래스의 이름에 맞게 직관적인 명칭으로 변환된 것
@RequestMapping("/api/v1/books") // localhost:8090/api/v1/books ~
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) { // 생성자, BookServiceImpl 받아옴
        this.bookService = bookService;
    }
    
    @GetMapping() // GET 요청 : api/v1/books
    public List<BookDTO> findAllBooks() {
        // service -> repository -> DB
        // 전체 책 데이터 조회
        return bookService.findAllBooks(); // List<BookDTO> 받아옴
        
    }
}
