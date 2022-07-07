package com.example.demo.Controller.Account;

import com.example.demo.Exception.PasswordMissMatchException;
import com.example.demo.Exception.UserAlreadyExist;
import com.example.demo.Security.Account;
import com.example.demo.Security.AccountRepo;
import com.example.demo.Security.AccountService;
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
    @Autowired
    private AccountService accountService;
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
        try{
            accountService.registUser(user);
        }
        catch (UserAlreadyExist e){
            model.addAttribute("user", user);
            br.rejectValue("username","user.username",e.getMessage());
            return "regist";
        }
        catch (PasswordMissMatchException e){
            model.addAttribute("user", user);
            br.rejectValue("password","user.password",e.getMessage());
            return "regist";
        }
        return "redirect:/login";
    }

}
