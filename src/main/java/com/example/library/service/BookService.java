package com.example.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.model.Book;
import com.example.library.repository.BookRepository;

import java.util.List;
import java.util.Optional;


@Service
public class BookService {

        @Autowired
        BookRepository bookRepository;
        
        // CREATE
        public Book createBook(Book book) {
            return bookRepository.save(book);
        }
        
        public List<Book> getAllBooks() {
            return bookRepository.findAll();
        }
        
        public Optional<Book> getBookById(Long id) {
            return bookRepository.findById(id);
        }
        
        public Book updateBook(Long id, Book bookDetails) {
            Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            book.setIsbn(bookDetails.getIsbn());
            return bookRepository.save(book);
        }
        
}
