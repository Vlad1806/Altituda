package ru.vlad.altituda.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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
        model.addAttribute("categories", categoriesDAO.index());
        return "categories/listCategories";
    }


    @GetMapping("/subCategories")
    public String subCategories(){
        return "/subCategories";
    }
    @GetMapping("/users")
    public String users(){
        return "/users";
    }
    @GetMapping("/order")
    public String order(){
        return "/order";
    }
    @GetMapping("/product")
    public String product(){
        return "/product";
    }
    @GetMapping("/producer")
    public String producer(){
        return "/producer";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("categories", categoriesDAO.show(id));
        return "redirect:/categories";
    }


    @GetMapping("/new")
    public String newPerson(@ModelAttribute("categories") Categories categories){
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
        model.addAttribute("categories", categoriesDAO.show(id));
        return "categories/edit";
    }

    @PostMapping ("/{id}")
    public String update(@ModelAttribute("categories") @Valid Categories categories,BindingResult bindingResult,
                         @PathVariable("id")int id){
        if (bindingResult.hasErrors()){
            return "categories/edit";
        }
        categoriesDAO.update(id,categories);
        return "redirect:/categories";
    }


    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id){
        categoriesDAO.delete(id);
        return "redirect:/categories";
    }
}
