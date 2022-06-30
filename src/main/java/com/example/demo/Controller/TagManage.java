package com.example.demo.Controller;

import com.example.demo.Database.Tag;
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
public class TagManage {
    @Autowired
    private TagRepo repo;
    //Add Tag
    @RequestMapping("/tag/add")
    public String addTag(Model model){
        model.addAttribute("tag",new Tag());
        return "tagForm";
    }
    @PostMapping("/tag/add")
    public String addTagHandle(@Valid @ModelAttribute("tag") Tag tag, BindingResult br){
        if(br.hasErrors()){
            return "tagForm";
        }
        repo.save(tag);
        return "redirect:/";
    }
    //Update Tag
    @RequestMapping("/tag/update/{id}")
    public String updateTag(@PathVariable("id") int id, Model model){
        model.addAttribute("tag",repo.findById(id).orElse(null));
        return "tagForm";
    }
    @PostMapping("/tag/update/{id}")
    public String updateTagHandle(@Valid@ModelAttribute("tag") Tag tag, BindingResult br){
        if(br.hasErrors()){
            return "tagForm";
        }
        repo.save(tag);
        return "redirect:/";
    }
    //Delete Tag
    @RequestMapping("/tag/delete/{id}")
    public String deleteTag(@PathVariable("id") int id){
        repo.deleteById(id);
        return "redirect:/";
    }
}
