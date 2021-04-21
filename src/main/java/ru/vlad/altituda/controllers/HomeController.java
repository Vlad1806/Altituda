package ru.vlad.altituda.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.vlad.altituda.Model.Categories;
import ru.vlad.altituda.Model.Producer;
import ru.vlad.altituda.Model.Product;
import ru.vlad.altituda.Model.SubCategories;
import ru.vlad.altituda.dao.ProductDAO;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private final ProductDAO productDAO;


    public HomeController(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }
    @GetMapping()
    public String wood(Model model){
        model.addAttribute("subcategories",productDAO.subCategoriesByCategories(1));
        model.addAttribute("product",productDAO.bySubCategory(1,1));
        return "home/wood";
    }
    @GetMapping("/{id}/wood")
    public String sortSubCategoryWood(@PathVariable("id") int id, Model model){
        List<SubCategories> subCategories = productDAO.subCategoriesByCategories(1);
        model.addAttribute("subcategories",subCategories);
        model.addAttribute("product",productDAO.bySubCategory(1,id));
        return "home/wood";
    }

    @GetMapping("/metal")
    public String metal(Model model){
        model.addAttribute("subcategories",productDAO.subCategoriesByCategories(3));
        model.addAttribute("product",productDAO.bySubCategory(3,7));
        return "home/metal";
    }

    @GetMapping("/{id}/metal")
    public String sortSubCategoryMetal(@PathVariable("id") int id, Model model){
        List<SubCategories> subCategories = productDAO.subCategoriesByCategories(3);
        model.addAttribute("subcategories",subCategories);
        model.addAttribute("product",productDAO.bySubCategory(3,id));
        return "home/metal";
    }

    @GetMapping("/krovlya")
    public String krovlya(Model model){
        model.addAttribute("subcategories",productDAO.subCategoriesByCategories(2));
        model.addAttribute("product",productDAO.bySubCategory(2,5));
        return "home/krovlya";
    }

    @GetMapping("/{id}/krovlya")
    public String sortSubCategoryKrovlya(@PathVariable("id") int id, Model model){
        List<SubCategories> subCategories = productDAO.subCategoriesByCategories(2);
        model.addAttribute("subcategories",subCategories);
        model.addAttribute("product",productDAO.bySubCategory(2,id));
        return "home/krovlya";
    }
}
