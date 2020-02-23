package com.avtech.springboot.mongodb.controller;

import com.avtech.springboot.mongodb.model.Book;
import com.avtech.springboot.mongodb.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mongodb-demo")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/add-book")
    public String saveBook(@RequestBody Book book){
        bookRepository.save(book);
        return "Book added successfully for id: "+book.getId();
    }

    @GetMapping("/get-all-books")
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    @GetMapping("/get-book/{id}")
    public Optional<Book> getBookById(@PathVariable int id){
        return bookRepository.findById(id);
    }

    @DeleteMapping("/delete-book/{id}")
    public String deleteBook(@PathVariable int id){
        bookRepository.deleteById(id);
        return "Book deleted for id: "+id;
    }
}
