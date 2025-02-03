package com.bookStore.BookStore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookStore.BookStore.entities.Book;
import com.bookStore.BookStore.services.BookService;

import org.springframework.web.bind.annotation.RequestMapping;

import com.bookStore.BookStore.entities.MyBookList;
import com.bookStore.BookStore.services.MyBookService;

@Controller
public class BookController {
    
    @Autowired
    private BookService bookService;

    @Autowired
    private MyBookService myBookService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/my_books")
    public String getMyBooks(Model model) {
        List<MyBookList> list = myBookService.myBookLists();
        model.addAttribute("book" ,list);
        return "myBooks";
    }

    @RequestMapping("/deleteMyBook/{id}")
    public String deleteMyBook(@PathVariable("id") int id){
        myBookService.deleteMyBook(id);
        
        return "redirect:/my_books";
    }

    @RequestMapping("/deleteBook/{id}")
    public String requestMethodName(@PathVariable("id") int id) {
        bookService.deleteById(id);
        return "redirect:/available_book";
    }
    

    @RequestMapping("/mylist/{id}")
    public String addToMyList(@PathVariable("id") int id) {
        Book b = bookService.getBookById(id);
        MyBookList myBook = new MyBookList(b.getId(), b.getName(), b.getAuthor());
        myBookService.saveMyBook(myBook);
        return "redirect:/my_books";
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

    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id, Model model) {
        Book b = bookService.getBookById(id);
        model.addAttribute("book" ,b);
        return "bookEdit";
    }
    
    
    @GetMapping("/available_book")
    public ModelAndView getAllBooks() {
        List<Book> list = bookService.allBooks();
        return new ModelAndView("availableBook", "book", list);
    }
    
}
