package com.gestion.app.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gestion.app.Repositories.UserRepository;
import com.gestion.app.entities.User;



@Controller
public class UserProduct {
    @Autowired
    private UserRepository userModel;
   @GetMapping("/")
   public String index(Model model) {
       List<User> list;
       list=userModel.findAll();
       model.addAttribute("list", list);
       return "index";
   }
   @GetMapping("/ajouter")
   public String ajouter(Model model) {
       model.addAttribute("newUser", new User());
       return "ajouter";
   }
   @PostMapping("/save")
   public String save(@ModelAttribute User newUser) {

       userModel.save(newUser);
       return "redirect:/";
   }
   @GetMapping("/editer")
   public String editer(@RequestParam long id, Model model) {
       Optional<User> us = userModel.findById(id);
       model.addAttribute("User", us);
       return "editer";
   }
   @GetMapping("/update")
   public String update(@RequestParam long id, @RequestParam String nom, @RequestParam String prenom,
           @RequestParam String email, @RequestParam String sexe) {
       userModel.updateUserById(id, nom, prenom, email, sexe);
       return "redirect:/";
   }
   @GetMapping("/delete")
   public String delete(@RequestParam long id) {
    userModel.deleteById(id);
       return "redirect:/";
   }
}
