package com.bookStore.BookStore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookStore.BookStore.entities.Book;
import com.bookStore.BookStore.services.BookService;


@Controller
public class BookController {
    
    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/book_register")
    public String bookRegister() {
        return "bookRegister";
    }

    @PostMapping("/bookRegister")
    public String createBook(@ModelAttribute Book book) {
        bookService.save(book);
        
        return "redirect:/available_book";
    }
    
    @GetMapping("/available_book")
    public ModelAndView getAllBooks() {
        List<Book> list = bookService.allBooks();
        return new ModelAndView("availableBook", "book", list);
    }
    
}
