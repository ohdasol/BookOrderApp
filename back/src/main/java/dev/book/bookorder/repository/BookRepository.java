package dev.book.bookorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.book.bookorder.model.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> { // DAO, 추상화
    Book findByName(String name); // name 필드에 매칭
}
