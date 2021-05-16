package ru.vlad.altituda.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.vlad.altituda.JDBC.Registration;
import ru.vlad.altituda.Model.Categories;
import ru.vlad.altituda.dao.CategoriesDAO;

import javax.validation.Valid;

@Controller
@RequestMapping("/categories")
public class CategoriesController {

    @Autowired
    private final CategoriesDAO categoriesDAO;

    public CategoriesController(CategoriesDAO categoriesDAO) {
        this.categoriesDAO = categoriesDAO;
    }

    @GetMapping()
    public String index(Model model){
        if (Registration.isRegistration() != true) return "redirect:/login";
        model.addAttribute("categories", categoriesDAO.index());
        model.addAttribute("user",Registration.getUsers());
        return "categories/listCategories";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("categories", categoriesDAO.show(id));
        model.addAttribute("user",Registration.getUsers());
        return "redirect:/categories";
    }


    @GetMapping("/new")
    public String newPerson(@ModelAttribute("categories") Categories categories,Model model){
        if (Registration.isRegistration() != true) return "redirect:/login";
        model.addAttribute("user",Registration.getUsers());
        return "categories/new";
    }


    @PostMapping()
    public String create(@ModelAttribute("categories") @Valid Categories categories,
                         BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "categories/new";
        }
        categoriesDAO.save(categories);
        return "redirect:/categories";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        if (Registration.isRegistration() != true) return "redirect:/login";
        model.addAttribute("user",Registration.getUsers());
        model.addAttribute("categories", categoriesDAO.show(id));
        return "categories/edit";
    }

    @PostMapping ("/{id}")
    public String update(@ModelAttribute("categories") @Valid Categories categories,BindingResult bindingResult,
                         @PathVariable("id")int id){
        if (Registration.isRegistration() != true) return "redirect:/login";
        if (bindingResult.hasErrors()){
            return "categories/edit";
        }
        categoriesDAO.update(id,categories);
        return "redirect:/categories";
    }


    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id){
        if (Registration.isRegistration() != true) return "redirect:/login";
        categoriesDAO.delete(id);
        return "redirect:/categories";
    }
}
