package com.bookStore.BookStore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {
    
    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/book_register")
    public String bookRegister() {
        return "bookRegister";
    }
    
    @GetMapping("/available_book")
    public String getAllBooks() {
        return "availableBook";
    }
    
}
