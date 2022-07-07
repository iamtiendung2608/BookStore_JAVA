package com.example.demo.Service;

import com.example.demo.Database.Address;
import com.example.demo.Database.Payment;
import com.example.demo.Exception.PasswordMissMatchException;
import com.example.demo.Security.Account;
import com.example.demo.Security.AccountRepo;
import com.example.demo.Security.Role;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserService {
    @NotNull
    @Size(min=2,message = "username's length must longer than 2 digits")
    private String username;
    @NotNull
    @Size(min=8,message = "password's length must equal or longer than 8 digits")
    private String password;
    @NotNull
    @Size(min=8,message = "confirm password's length must equal or longer than 8 digits")
    private String confirmPassword;
    private int age;
    private String gender;
    @NotNull
    private String phone;
    public Account toUSer(PasswordEncoder encoder) throws PasswordMissMatchException {
        Account account =  new Account(username,encoder.encode(password),age,gender,phone, Role.CUSTOMER);
        Address address = new Address();
        Payment payment = new Payment();
        account.setAddress(address);
        account.setPayment(payment);
        return account;
    }
    public boolean checkPassword(){
        return password.equals(confirmPassword);
    }
}
