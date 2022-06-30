package com.example.demo.Controller;

import com.example.demo.Database.Book;
import com.example.demo.Service.BookRepo;
import com.example.demo.Service.TagRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class Homepage {
    private BookRepo bookRepo;
    private TagRepo tagRepo;
    @Autowired
    public Homepage(BookRepo bookRepo, TagRepo tagRepo) {
        this.bookRepo = bookRepo;
        this.tagRepo = tagRepo;
    }

    @RequestMapping("/")
    public String homepageHandler(@RequestParam(defaultValue = "") String name, Model model){

        List<Book> Result = name.equals("") ? (List<Book>) bookRepo.findAll() : bookRepo.findAllByNameContainsIgnoreCase(name);
        model.addAttribute("books",Result);
        model.addAttribute("tags",tagRepo.findAll());
        return "home";
    }

    @RequestMapping("/product/{id}")
    public String productDetails(@PathVariable("id") int id, Model model){
        Book book = bookRepo.findById(id).orElse(null);
        model.addAttribute("book",book);
        model.addAttribute("books", bookRepo.findAllByTag(book.getTag()));
        return "productDetails";
    }
    @RequestMapping("/tag/{id}")
    public String findByTagID(@PathVariable int id, Model model){
        model.addAttribute("books", bookRepo.findAllByTagId(id));
        model.addAttribute("tags",tagRepo.findAll());
        return "home";
    }
}
