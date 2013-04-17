package com.example.service;

import com.example.entity.Book;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class BookService {
    @PersistenceContext
    private EntityManager em;

    public void addBook() {
        Book book = new Book();
        em.persist(book);
    }

    public List<Book> findAll() {
        return em.createQuery("select b from Book b", Book.class).getResultList();
    }
}
