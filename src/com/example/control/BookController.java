package com.example.control;

import com.example.entity.Book;
import com.example.service.BookService;

import javax.ejb.EJB;
import javax.enterprise.inject.Model;
import javax.inject.Named;
import java.util.List;

@Model @Named(value = "book")
public class BookController {
    @EJB
    private BookService bookService;

    private List<Book> items;

    public List<Book> getItems() {
        return items;
    }

    public String addBook() {
        bookService.addBook();
        return findAll();
    }

    public String findAll() {
        items = bookService.findAll();
        return "index.xhtml";
    }

}
