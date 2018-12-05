package com.example.spring_rest_sample.controller;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.spring_rest_sample.dao.Book;
import com.example.spring_rest_sample.dao.BookDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;

@Api(description = "RESTFull webservice")
@RestController
@RequestMapping("/rest")
public class BookController {

    @Autowired
    private BookDao bookDao;

    @ApiOperation(value = "모든 책 리스트", response = List.class)
    @RequestMapping(value = "/books", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE })
    public List<Map<String, Object>> getBooks() {

        return bookDao.findAll();
    }

    @ApiOperation(value = "책 조회 by Id")
    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE })
    public Optional<Book> getBook(@ApiParam("Id of the book") @PathVariable Long id) {
        Optional<Book> book = bookDao.findById(id);
        if (!book.isPresent())
            throw new BookNotFoundException("id : " + id);

        return book;
    }

    @ApiOperation(value = "새 책 등록")
    @ApiResponse(code = 201, message = "created")
    @RequestMapping(value = "/books", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<Object> createBook(@RequestBody Book book) {
        Book rsBook = bookDao.create(book);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(rsBook.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @ApiOperation(value = "책 삭제 by Id")
    @RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
    public void deleteBook(@ApiParam("Id of the book") @PathVariable Long id) {
        bookDao.delete(id);
    }

    @ApiOperation(value = "책 수정. by Id")
    @RequestMapping(value = "/books/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateBook(@RequestBody Book book, @PathVariable Long id) {
        book.setId(id);
        bookDao.update(book);

        return ResponseEntity.noContent().build();
    }

}