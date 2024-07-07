package com.graphQlPractice.services;

import com.graphQlPractice.entities.Book;
import com.graphQlPractice.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;
    public Book create(Book b) {
        return bookRepository.save(b);
    }

    public List<Book> getAll() {

        return (List<Book>) bookRepository.findAll();
    }

    public Book get(int bookId) {

        return bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book you are looking for not found on server !!"));
    }
}
