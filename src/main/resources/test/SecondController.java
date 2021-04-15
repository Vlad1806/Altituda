package ru.vlad.altituda.controllers.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecondController {

    @GetMapping("/exit")
    public String exit(){
        return "second/exit";
    }
}
