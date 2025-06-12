package com.example.books;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping("/books")
public class BooksApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksApplication.class, args);
	}

	@GetMapping
	public String getBooks() {
		return "Retrieving all books";
	}

	@PostMapping
	public String createBook(@RequestBody BookRequest request) {
		return String.format("Book created for %s.", request.getName());
	}

	@PutMapping("/{id}")
	public String updateBook(@PathVariable String id, @RequestBody BookRequest request) {
		return String.format("Book with ID %s reimagined", id, request.getName());
	}

	@DeleteMapping("/{id}")
	public String deleteBook(@PathVariable String id) {
		return String.format("Book with ID %s removed", id);
	}

}
