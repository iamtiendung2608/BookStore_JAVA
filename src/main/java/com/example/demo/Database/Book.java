package com.example.demo.Database;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@Entity
@Data
@NoArgsConstructor

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Size(min = 1,message = "Book name mustn't be null")
    private String name;
    @Min(value = 1000, message = "Price must be in vietnamese price")
    private long price;
    @Size(min = 1,message = "Book author mustn't be null")
    private String author;
    @Size(min = 1,message = "Book image mustn't be null")
    private String image;
    @Size(min = 1,message = "Book describe mustn't be null")
    private String describe;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Tag tag;
}
