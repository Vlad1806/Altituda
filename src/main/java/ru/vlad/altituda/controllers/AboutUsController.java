package ru.vlad.altituda.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/aboutUs")
public class AboutUsController {

    @GetMapping()
    public String about(){
        return "aboutUs/aboutUs";
    }

    @GetMapping("/home")
    public String home(){
        return "home/wood";
    }
}
