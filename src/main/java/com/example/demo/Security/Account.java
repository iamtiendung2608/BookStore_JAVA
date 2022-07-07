package com.example.demo.Security;

import com.example.demo.Database.Address;
import com.example.demo.Database.Order;
import com.example.demo.Database.Payment;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Account implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private int age;
    private String gender;
    private String phone;
    private Role role;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "account", orphanRemoval = true)
    private Payment payment;
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "account", orphanRemoval = true)
    private Address address;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "account", orphanRemoval = true)
    List<Order>orders = new ArrayList<>();

    public void addOrders(Order order) {
        this.orders.add(order);
    }
    public void removeOrders(Order order) {
        this.orders.remove(order);
    }

    public Account(String username, String password, int age, String gender, String phone, Role role) {
        this.username=username;
        this.password=password;
        this.age=age;
        this.gender=gender;
        this.phone=phone;
        this.role=role;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
