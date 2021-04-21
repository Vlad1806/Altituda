package ru.vlad.altituda.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.vlad.altituda.Model.Producer;
import ru.vlad.altituda.Model.Product;
import ru.vlad.altituda.Model.SubCategories;
import ru.vlad.altituda.dao.ProductDAO;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private final ProductDAO productDAO;

    public ProductController(ProductDAO productDAO) {
        this.productDAO = productDAO;
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



    @GetMapping()
    public String index(Model model){
        model.addAttribute("product", productDAO.index());
        return "product/listProduct";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("product", productDAO.show(id));
        return "redirect:/product";
    }


    @GetMapping("/new")
    public String newPerson(Model model ,@ModelAttribute("product") Product product){
        List<SubCategories> sub = productDAO.allSubCategories();
        List<Producer> producer = productDAO.allProducer();
        model.addAttribute("producer",producer);
        model.addAttribute("subCategories",sub);
        return "product/new";
    }
//    List<SubCategories> sub = productDAO.allSubCategories();
//    List<Producer> producer = productDAO.allProducer();
//        model.addAttribute("producer",producer);
//        model.addAttribute("subCategories",sub);

    @PostMapping()
    public String create(Model model ,@ModelAttribute("product") @Valid Product product,
                         BindingResult bindingResult){
        if (bindingResult.hasErrors()){
                List<SubCategories> sub = productDAO.allSubCategories();
    List<Producer> producer = productDAO.allProducer();
        model.addAttribute("producer",producer);
        model.addAttribute("subCategories",sub);
            return "product/new";
        }
        productDAO.save(product);
        return "redirect:/product";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        List<SubCategories> sub = productDAO.allSubCategories();
        List<Producer> producer = productDAO.allProducer();
        model.addAttribute("producer",producer);
        model.addAttribute("subCategories",sub);
        model.addAttribute("product", productDAO.show(id));
        return "product/edit";
    }

    @PostMapping ("/{id}")
    public String update(@ModelAttribute("product") @Valid Product product,BindingResult bindingResult,
                         @PathVariable("id")int id){
        if (bindingResult.hasErrors()){
            return "product/edit";
        }
        productDAO.update(id,product);
        return "redirect:/product";
    }


    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id){
        productDAO.delete(id);
        return "redirect:/product";
    }
}
