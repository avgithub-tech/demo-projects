package com.avtech.springboot.mongodb.repository;

import com.avtech.springboot.mongodb.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, Integer> {

}
