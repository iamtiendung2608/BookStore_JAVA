package com.example.demo.Controller.AddressAndPayment;

import com.example.demo.Security.Account;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class PaymentController {
    @RequestMapping("/address")
    private String addressHandle(Authentication authentication, Model model){
        Account user = (Account) authentication.getPrincipal();
        model.addAttribute("address", user.getAddress());
        return "address";
    }
    @PostMapping("/address")
    private String addressPostHandle(){

        return "redirect:/";
    }

}
