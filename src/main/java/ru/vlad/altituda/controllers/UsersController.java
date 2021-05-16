package ru.vlad.altituda.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.vlad.altituda.JDBC.Registration;
import ru.vlad.altituda.Model.Users;
import ru.vlad.altituda.dao.ProductDAO;
import ru.vlad.altituda.dao.SubCategoriesDAO;
import ru.vlad.altituda.dao.UserDAO;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private final UserDAO userDAO;
    @Autowired
    private final ProductDAO productDAO;

    public UsersController(UserDAO userDAO, ProductDAO productDAO) {
        this.userDAO = userDAO;
        this.productDAO = productDAO;
    }

    @GetMapping()
    public String index(Model model){
        if (Registration.isRegistration() != true) return "redirect:/login";
        model.addAttribute("user",Registration.getUsers());
        model.addAttribute("users", userDAO.index());
        return "users/listUsers";
    }

    @GetMapping("/{email}")
    public String show(@PathVariable("email") String email, Model model){
        if (Registration.isRegistration() != true) return "redirect:/login";
        model.addAttribute("user",Registration.getUsers());
        model.addAttribute("users", userDAO.show(email));
        return "redirect:/users";
    }


    @GetMapping("/new")
    public String newPerson(@ModelAttribute("users") Users users,Model model){
        if (Registration.isRegistration() != true) return "redirect:/login";
        model.addAttribute("user",Registration.getUsers());
        return "users/new";
    }


    @PostMapping()
    public String create(@ModelAttribute("users") @Valid Users users,
                         BindingResult bindingResult){
        if (Registration.isRegistration() != true) return "redirect:/login";
        if (bindingResult.hasErrors()){
            return "users/new";
        }
        userDAO.save(users);
        return "redirect:/users";
    }

    @GetMapping("/{email}/edit")
    public String edit(Model model, @PathVariable("email") String email){
        if (Registration.isRegistration() != true) return "redirect:/login";
        model.addAttribute("user",Registration.getUsers());
        model.addAttribute("users", userDAO.show(email));
        return "users/edit";
    }

    @PostMapping ("/{email}")
    public String update(@ModelAttribute("users") @Valid Users users,BindingResult bindingResult,
                         @PathVariable("email") String email){
        if (Registration.isRegistration() != true) return "redirect:/login";
        if (bindingResult.hasErrors()){
            return "users/edit";
        }
        userDAO.update(email,users);
        return "redirect:/users";
    }

    @GetMapping("/{email}/delete")
    public String delete(@PathVariable("email") String email){
        if (Registration.isRegistration() != true) return "redirect:/login";
        userDAO.delete(email);
        return "redirect:/users";
    }
}
