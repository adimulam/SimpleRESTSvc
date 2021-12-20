package com.howtodoinjava.rest.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.howtodoinjava.rest.dao.BookDAO;
import com.howtodoinjava.rest.model.Book;
import com.howtodoinjava.rest.model.Books;

@Service
@RestController
@RequestMapping(path = "/books")
public class BookController
{
    @Autowired
    private BookDAO bookDao;
    
    @GetMapping(path="/", produces = "application/json")
    public Books getBooks()
    {
        return bookDao.getAllBooks();
    }

    @GetMapping(path="/id/", produces = "application/json")
    public Book getBookById(@RequestParam String id) {
        System.out.println("Processing request to getBookId for id:" + id);
        return bookDao.getBookById(id);
    }

    @PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addBook(
                        @RequestHeader(name = "X-COM-PERSIST", required = true) String headerPersist,
                        @RequestHeader(name = "X-COM-LOCATION", required = false, defaultValue = "ASIA") String headerLocation,
                        @RequestBody Book book)
                 throws Exception 
    {       
        //Generate resource id
        Integer id = bookDao.getAllBooks().getBookList().size() + 1;
        book.setId(id);
        
        //add resource
        bookDao.addBook(book);
        
        //Create resource location
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{id}")
                                    .buildAndExpand(book.getId())
                                    .toUri();
        
        //Send location in response
        return ResponseEntity.created(location).build();
    }
}
