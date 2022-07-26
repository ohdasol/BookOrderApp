package dev.book.bookorder.service;

import java.util.List;

import dev.book.bookorder.model.dto.BookDTO;

public interface BookService { // class BookServiceImpl ServiceImpl
    List<BookDTO> findAllBooks();
}