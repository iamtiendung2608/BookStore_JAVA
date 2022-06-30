package com.example.demo.Controller.Order;

import com.example.demo.Database.Order;
import com.example.demo.Security.Account;
import com.example.demo.Service.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class Cart {
    @Autowired
    private OrderRepo repo;
    @RequestMapping("/cart")
    private String viewCart(Authentication authentication, Model model){
        Account user = (Account) authentication.getPrincipal();
        List<Order>getOrder = repo.findAllByAccount(user);
        model.addAttribute("orders", getOrder);
        return "cart";
    }
}
