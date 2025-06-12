package com.example.bookapi.repository;

import com.example.bookapi.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
  Page<Book> findByTitleContainingIgnoreCase(String title, Pageable pageable);
}
