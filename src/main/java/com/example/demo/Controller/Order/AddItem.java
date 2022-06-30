package com.example.demo.Controller.Order;

import com.example.demo.Database.Book;
import com.example.demo.Database.Order;
import com.example.demo.Security.Account;
import com.example.demo.Service.BookRepo;
import com.example.demo.Service.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AddItem {
    private OrderRepo orderRepo;
    private BookRepo bookRepo;

    @Autowired
    public AddItem(OrderRepo orderRepo, BookRepo bookRepo) {
        this.orderRepo = orderRepo;
        this.bookRepo = bookRepo;
    }
    @PreAuthorize("hasRole('customer')")
    @RequestMapping("/add/{id}")
    private String AddToCart(@PathVariable int id, Authentication authentication){
        Account user = (Account) authentication.getPrincipal();
        Book item = bookRepo.findById(id).orElse(null);
        Order order = orderRepo.findByAccountAndBook(user,item);
        if(order!=null){
            order.addBook();
            orderRepo.save(order);
        }
        else{
            orderRepo.save(new Order(user,item));
        }
        return "redirect:/";
    }
}
