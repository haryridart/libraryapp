package com.haryridart.libraryapp.repository;

import com.haryridart.libraryapp.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Integer> {
    @Query(value = "SELECT b FROM Book b WHERE bookId = ?1")
    Optional<Book> findByBookId(String bookId);
    @Query(value = "SELECT b FROM Book b WHERE b.borrow.status =?1")
    List<Book> findAllByStatus(Integer status);
}
