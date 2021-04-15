package ru.vlad.altituda.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.vlad.altituda.Model.SubCategories;
import ru.vlad.altituda.dao.SubCategoriesDAO;

import javax.validation.Valid;

@Controller
@RequestMapping("/subCategories")
public class SubCategoriesController {

    @Autowired
    private final SubCategoriesDAO subCategoriesDAO;

    public SubCategoriesController(SubCategoriesDAO subCategoriesDAO) {
        this.subCategoriesDAO = subCategoriesDAO;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("subCategories",subCategoriesDAO.index());
        return "subCategories/listSubCategories";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("subCategories",subCategoriesDAO.show(id));
        return "redirect:/subCategories";
    }


    @GetMapping("/new")
    public String newSubCategory(@ModelAttribute("subCategories") SubCategories subCategories){
        return "subCategories/new";
    }


    @PostMapping()
    public String create(@ModelAttribute("subCategories") @Valid SubCategories subCategories,
                         BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "subCategories/new";
        }
        subCategoriesDAO.save(subCategories);
        return "redirect:/subCategories";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("subCategories",subCategoriesDAO.show(id));
        return "subCategories/edit";
    }

    @PostMapping ("/{id}")
    public String update(@ModelAttribute("subCategories") @Valid SubCategories subCategories,BindingResult bindingResult,
                         @PathVariable("id")int id){
        if (bindingResult.hasErrors()){
            return "subCategories/edit";
        }
        subCategoriesDAO.update(id,subCategories);
        return "redirect:/subCategories";
    }


    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        subCategoriesDAO.delete(id);
        return "redirect:/subCategories";
    }
}
