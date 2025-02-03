package com.bookStore.BookStore.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bookStore.BookStore.entities.Book;
import com.bookStore.BookStore.repositories.BookRepository;

@Service
public class BookService {
 
    @SuppressWarnings("FieldMayBeFinal")
    private BookRepository bookRepository;
    
    //dependence injection
    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    // method for save a new book
    public void save(Book book){
        bookRepository.save(book);
    }

    // method for list all books
    public List<Book> allBooks(){
        return bookRepository.findAll();
    }
}
