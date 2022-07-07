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
public class Payment {
    @Id
    private int id;
    private String bank;
    private String number;
    private String exp;
    @OneToOne
    private Account account;
}
