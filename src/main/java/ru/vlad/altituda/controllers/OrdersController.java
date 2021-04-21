package ru.vlad.altituda.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.vlad.altituda.Model.Orders;
import ru.vlad.altituda.dao.OrdersDAO;

import javax.validation.Valid;

@Controller
@RequestMapping("/order")
public class OrdersController {
    @Autowired
    private final OrdersDAO ordersDAO;

    public OrdersController(OrdersDAO ordersDAO) {
        this.ordersDAO = ordersDAO;
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
        model.addAttribute("orders", ordersDAO.index());
        return "order/listOrders";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("orders", ordersDAO.show(id));
        return "redirect:/order";
    }


    @GetMapping("/new")
    public String newPerson(@ModelAttribute("orders") Orders orders){
        return "order/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("orders") @Valid Orders orders,
                         BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "order/new";
        }
        ordersDAO.save(orders);
        return "redirect:/order";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("orders", ordersDAO.show(id));
        return "order/edit";
    }

    @PostMapping ("/{id}")
    public String update(@ModelAttribute("orders") @Valid Orders orders,BindingResult bindingResult,
                         @PathVariable("id")int id){
        if (bindingResult.hasErrors()){
            return "order/edit";
        }
        ordersDAO.update(id,orders);
        return "redirect:/order";
    }


    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id){
        ordersDAO.delete(id);
        return "redirect:/order";
    }
}

