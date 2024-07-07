package com.graphQlPractice.controllers;

import com.graphQlPractice.entities.BookInput;
import com.graphQlPractice.services.BookService;
import com.graphQlPractice.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @PreAuthorize("hasRole('ADMIN')")
    @MutationMapping("createBook")
    public Book create(@Argument BookInput bookInput) {
        if(bookInput != null) {
            Book b=new Book();
            b.setTitle(bookInput.getTitle());
            b.setDetails(bookInput.getDesc());
            b.setAuthor(bookInput.getAuthor());
            b.setPages(bookInput.getPages());
            return this.bookService.create(b);
        } else {
            System.out.println("Book Input is null");
        }
        return null;
    }

    @Secured("ROLE_USER")
    @QueryMapping("allBooks")
    public List<Book> getAll() {
        return this.bookService.getAll();
    }

    @QueryMapping("getBook")
    public Book get(@Argument int bookId) {
        return this.bookService.get(bookId);
    }

}
