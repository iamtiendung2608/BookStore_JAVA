package com.example.demo.Service;

import com.example.demo.Database.Book;
import com.example.demo.Database.Tag;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepo extends CrudRepository<Book,Integer> {
    List<Book>findAllByTag(Tag tag);
    List<Book>findAllByTagId(int tagid);
    List<Book>findAllByNameContainsIgnoreCase(String name);
}
