package com.example.demo.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements UserDetailsService {
    @Autowired
    private AccountRepo repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account user = repo.findByUsername(username);
        if(user != null){
            return user;
        }
        throw new UsernameNotFoundException("username not found");
    }

}
