package com.example.bookapi.service;

import com.example.bookapi.model.Book;
import com.example.bookapi.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

@Service
public class BookService {
  private final BookRepository repo;

  public BookService(BookRepository repo) {
    this.repo = repo;
  }

  public Page<Book> getBooks(int page, int size, String title) {
    Pageable pageable = PageRequest.of(page, size, Sort.by("title").ascending());

    if (title != null && !title.isBlank()) {
      return repo.findByTitleContainingIgnoreCase(title, pageable);
    } else {
      return repo.findAll(pageable);
    }
  }

  public Book updateBook(Long id, Book updated) {
    Book existing = repo.findById(id).orElseThrow(() ->
      new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));

    existing.setTitle(updated.getTitle());
    existing.setAuthor(updated.getAuthor());
    existing.setYear(updated.getYear());

    return repo.save(existing);
  }

  public void deleteBook(Long id) {
    Book book = repo.findById(id).orElseThrow(() ->
      new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));
    repo.delete(book);
  }

  public List<Book> getAllBooks() {
    return repo.findAll();
  }

  public Book saveBook(Book book) {
    return repo.save(book);
  }

}
