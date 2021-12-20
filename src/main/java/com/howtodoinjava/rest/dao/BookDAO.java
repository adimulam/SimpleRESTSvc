package com.howtodoinjava.rest.dao;

import org.springframework.stereotype.Repository;

import com.howtodoinjava.rest.model.Book;
import com.howtodoinjava.rest.model.Books;

@Repository
public class BookDAO
{
    private final static Books list = new Books();
    
    static 
    {
        list.getBookList().add(new Book(1, "USA", "Hachette", "howtodoinJava@gmail.com", 100));
        list.getBookList().add(new Book(2, "India", "HarperCollins", "titanic@gmail.com", 250));
        list.getBookList().add(new Book(3, "Canada", "Macmillan", "abc@gmail.com", 300));
    }
    
    public Books getAllBooks()
    {
        return list;
    }
    
    public void addBook(Book book) {
        list.getBookList().add(book);
    }

    public Book getBookById(String id) {
        return list.getBookList().get(Integer.parseInt(id)-1);
    }
}
