package ru.vlad.altituda.controllers;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.vlad.altituda.JDBC.Registration;
import ru.vlad.altituda.Model.Login;
import ru.vlad.altituda.Model.Person;
import ru.vlad.altituda.Model.Users;
import ru.vlad.altituda.dao.UserDAO;

import javax.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    UserDAO userDAO;

    @GetMapping
    public String viewLogin(@ModelAttribute("user") Users users) {
        return "login/login";
    }

    @PostMapping()
    public String registration(@RequestParam("email") String email,
                               @RequestParam("password") String password,
                               @ModelAttribute("user") @Valid Login login,
                               BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "login/login";
        }
        if (email == "") return "redirect:/login";
        Users user = userDAO.show(email);
        if (user.getEmail() == null) return "redirect:/login";

        if (!user.getPassword().equals(password)) return "redirect:/login";
        Registration.setRegistration(true,user);
        return "redirect:/users";
    }
}
