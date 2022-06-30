package com.example.demo.Service;

import com.example.demo.Database.Book;
import com.example.demo.Database.Order;
import com.example.demo.Security.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepo  extends CrudRepository<Order,Integer> {
    List<Order>findAllByAccount(Account account);
    Order findByAccountAndBook(Account account, Book book);
}
