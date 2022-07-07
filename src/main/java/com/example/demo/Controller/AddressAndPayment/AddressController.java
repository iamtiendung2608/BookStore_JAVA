package com.example.demo.Controller.AddressAndPayment;

import com.example.demo.Security.Account;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AddressController {
    @RequestMapping("/payment")
    private String paymentHandle(Authentication authentication, Model model){
        Account user = (Account) authentication.getPrincipal();
        model.addAttribute("payment", user.getPayment());
        return "payment";
    }
    @PostMapping("/payment")
    private String paymentPostHandle(){

        return "redirect:/";
    }
}
