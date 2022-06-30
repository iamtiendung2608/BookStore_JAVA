package com.example.demo.Service;

import com.example.demo.Database.Tag;
import org.springframework.data.repository.CrudRepository;

public interface TagRepo extends CrudRepository<Tag,Integer> {
}
