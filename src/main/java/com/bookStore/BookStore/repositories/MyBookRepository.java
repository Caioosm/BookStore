package com.bookStore.BookStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookStore.BookStore.entities.MyBookList;

public interface MyBookRepository extends JpaRepository<MyBookList, Integer>{
    
}
