package com.example.demo.Database;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull(message = "Name mustn't be null")
    @Size(min=1)
    private String name;
    @NotNull(message = "Topic mustn't be null")
    @Size(min=1)
    private String topic;
    @OneToMany(cascade = CascadeType.ALL ,mappedBy = "tag", orphanRemoval = true)
    private List<Book>books = new ArrayList<>();
}
