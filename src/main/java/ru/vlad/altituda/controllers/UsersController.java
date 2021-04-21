package ru.vlad.altituda.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.vlad.altituda.Model.Users;
import ru.vlad.altituda.dao.UserDAO;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private final UserDAO userDAO;

    public UsersController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("users", userDAO.index());
        return "users/listUsers";
    }

    @GetMapping("/subCategories")
    public String subCategories(){
        return "/subCategories";
    }
    @GetMapping("/categories")
    public String categories(){
        return "/categories";
    }
    @GetMapping("/users")
    public String users(){
        return "/users";
    }

    @GetMapping("/{email}")
    public String show(@PathVariable("email") String email, Model model){
        model.addAttribute("users", userDAO.show(email));
        return "redirect:/users";
    }


    @GetMapping("/new")
    public String newPerson(@ModelAttribute("users") Users users){
        return "users/new";
    }


    @PostMapping()
    public String create(@ModelAttribute("users") @Valid Users users,
                         BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "users/new";
        }
        userDAO.save(users);
        return "redirect:/users";
    }

    @GetMapping("/{email}/edit")
    public String edit(Model model, @PathVariable("email") String email){
        model.addAttribute("users", userDAO.show(email));
        return "users/edit";
    }

    @PostMapping ("/{email}")
    public String update(@ModelAttribute("users") @Valid Users users,BindingResult bindingResult,
                         @PathVariable("email") String email){
        if (bindingResult.hasErrors()){
            return "users/edit";
        }
        userDAO.update(email,users);
        return "redirect:/users";
    }


    @GetMapping("/{email}/delete")
    public String delete(@PathVariable("email") String email){
        userDAO.delete(email);
        return "redirect:/users";
    }
}
