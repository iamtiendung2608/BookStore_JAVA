package com.example.demo.Controller.Account;

import com.example.demo.Security.Account;
import com.example.demo.Security.AccountRepo;
import com.example.demo.Security.Role;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import javax.naming.Binding;
import javax.persistence.PostLoad;
import javax.validation.Valid;

@Controller
public class Regist {
    private AccountRepo accountRepo;
    private PasswordEncoder passwordEncoder;

    public Regist(AccountRepo accountRepo, PasswordEncoder passwordEncoder) {
        this.accountRepo = accountRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @RequestMapping("/regist")
    private String registPage(Model model){
        model.addAttribute("user",new UserService());
        return "regist";
    }
    @PostMapping("/regist")
    private String registHandle(@Valid @ModelAttribute("user") UserService user , BindingResult br, Model model){
        if(br.hasErrors()){
            return "regist";
        }
        accountRepo.save(user.toUSer(passwordEncoder));
        return "redirect:/login";
    }
    @PostConstruct
    private void addUser(){
        accountRepo.save(new Account("tiendung",passwordEncoder.encode("123"),20,"male","0889047937", Role.ADMIN));
        accountRepo.save(new Account("user",passwordEncoder.encode("123"),20,"male","0889047937", Role.CUSTOMER));
    }
}
