package com.bookStore.BookStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookStore.BookStore.entities.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{
    
}
