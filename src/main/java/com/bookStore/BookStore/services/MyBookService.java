package com.bookStore.BookStore.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bookStore.BookStore.entities.MyBookList;
import com.bookStore.BookStore.repositories.MyBookRepository;

@Service
public class MyBookService {
    
    @SuppressWarnings("FieldMayBeFinal")
    private MyBookRepository repository;

    public MyBookService(MyBookRepository repository){
        this.repository = repository;
    }

    public void saveMyBook(MyBookList book){
        repository.save(book);
    }

    public List<MyBookList> myBookLists(){
        return repository.findAll();
    }

    public void deleteMyBook(int id){
        repository.deleteById(id);
    }
}
