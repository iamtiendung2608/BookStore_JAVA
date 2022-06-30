package com.example.demo.Database;

import com.example.demo.Security.Account;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name="book_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.REMOVE)
    private Account account;

    @ManyToOne(cascade = CascadeType.REMOVE)
    private Book book;

    private int quantity;


    public Order(Account account, Book book) {
        this.account = account;
        this.book = book;
        this.quantity=1;
    }
    public void addBook(){
        this.quantity+=1;
    }
}
