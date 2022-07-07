package com.example.demo.Security;

import com.example.demo.Exception.PasswordMissMatchException;
import com.example.demo.Exception.UserAlreadyExist;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class AccountService implements UserDetailsService {
    private AccountRepo repo;
    private PasswordEncoder passwordEncoder;
    @Autowired
    public AccountService(AccountRepo repo, PasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account user = repo.findByUsername(username);
        if(user != null){
            return user;
        }
        throw new UsernameNotFoundException("username not found");
    }
    @PostConstruct
    private void addUser(){
        repo.save(new Account("tiendung",passwordEncoder.encode("123"),20,"male","0889047937", Role.ADMIN));
        repo.save(new Account("user",passwordEncoder.encode("123"),20,"male","0889047937", Role.CUSTOMER));
    }
    public void registUser(UserService account) throws UserAlreadyExist, PasswordMissMatchException {
        if(!account.checkPassword()){
            throw new PasswordMissMatchException("Password and confirmed password miss match");
        }
        Account user = repo.findByUsername(account.getUsername());
        if(user != null){
            throw new UserAlreadyExist("Username is already exist!");
        }
        repo.save(account.toUSer(passwordEncoder));
    }
}
