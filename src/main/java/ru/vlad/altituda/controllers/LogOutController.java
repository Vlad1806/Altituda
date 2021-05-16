package ru.vlad.altituda.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.vlad.altituda.JDBC.Registration;
import ru.vlad.altituda.dao.ProductDAO;

@Controller
@RequestMapping("/logout")
public class LogOutController {

    @Autowired
    private ProductDAO productDAO;

    @GetMapping
    public String logOut(Model model){
        Registration.setRegistration(false,null);
        model.addAttribute("subcategories",productDAO.subCategoriesByCategories(1));
        model.addAttribute("product",productDAO.bySubCategory(1,1));
        return "redirect:/home";
    }
}
