package com.example.demo.Database;

import com.example.demo.Security.Account;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@NoArgsConstructor
@Entity
public class Address {
    @Id
    private int id;
    private String country;
    private String province;
    private String state;
    private String details;
    @OneToOne
    private Account account;
}
