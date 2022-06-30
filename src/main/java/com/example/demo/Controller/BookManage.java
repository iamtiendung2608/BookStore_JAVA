package com.example.demo.Controller;

import com.example.demo.Database.Book;
import com.example.demo.Service.BookRepo;
import com.example.demo.Service.TagRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class BookManage {
    private BookRepo bookRepo;
    private TagRepo tagRepo;
    @Autowired
    public BookManage(BookRepo bookRepo, TagRepo tagRepo) {
        this.bookRepo = bookRepo;
        this.tagRepo = tagRepo;
    }
    //Add book
    @RequestMapping("/book/add")
    public String addBook(Model model){
        model.addAttribute("tags",tagRepo.findAll());
        model.addAttribute("book", new Book());
        return "bookForm";
    }
    @PostMapping("/book/add")
    public String addBookHandle(@Valid @ModelAttribute("book")Book book, BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("tags",tagRepo.findAll());
            return "bookForm";
        }
        bookRepo.save(book);
        return "redirect:/";
    }
    //Update book
    @RequestMapping("/book/update/{id}")
    public String updateBook(@PathVariable("id") int id, Model model){
        model.addAttribute("book", bookRepo.findById(id).orElse(null));
        model.addAttribute("tags",tagRepo.findAll());
        return "bookForm";
    }
    @PostMapping("/book/update/{id}")
    public String updateBookHandle(@Valid@ModelAttribute("book") Book book, BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("tags",tagRepo.findAll());
            return "bookForm";
        }
        bookRepo.save(book);
        return "redirect:/";
    }
    @RequestMapping("/book/delete/{id}")
    public String deleteBook(@PathVariable("id") int id){
        bookRepo.deleteById(id);
        return "redirect:/";
    }
}
