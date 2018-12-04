package com.example.spring_rest_sample.controller;

import java.awt.print.Book;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.spring_rest_sample.dao.BookDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class BookController {

    @Autowired
    private BookDao bookDao;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<Map<String, Object>> getBooks() {

        return bookDao.findAll();
    }

    @RequestMapping(value = "books/{id}", method = RequestMethod.GET)
    public Optional<Book> getBook(@PathVariable Long id) {
        Optional<Book> book = bookDao.findById(id);

        return book;
    }
}