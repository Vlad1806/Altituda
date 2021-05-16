package ru.vlad.altituda.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.vlad.altituda.JDBC.Registration;
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

    @GetMapping()
    public String index(Model model){
        if (Registration.isRegistration() != true) return "redirect:/login";
        model.addAttribute("user",Registration.getUsers());
        model.addAttribute("orders", ordersDAO.index());
        return "order/listOrders";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        if (Registration.isRegistration() != true) return "redirect:/login";
        model.addAttribute("orders", ordersDAO.show(id));
        model.addAttribute("user",Registration.getUsers());
        return "redirect:/order";
    }


    @GetMapping("/new")
    public String newPerson(@ModelAttribute("orders") Orders orders,Model model){
        if (Registration.isRegistration() != true) return "redirect:/login";
        model.addAttribute("user",Registration.getUsers());
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
        if (Registration.isRegistration() != true) return "redirect:/login";
        model.addAttribute("user",Registration.getUsers());
        model.addAttribute("orders", ordersDAO.show(id));
        return "order/edit";
    }

    @PostMapping ("/{id}")
    public String update(@ModelAttribute("orders") @Valid Orders orders,BindingResult bindingResult,
                         @PathVariable("id")int id){
        if (Registration.isRegistration() != true) return "redirect:/login";
        if (bindingResult.hasErrors()){
            return "order/edit";
        }
        ordersDAO.update(id,orders);
        return "redirect:/order";
    }


    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id){
        if (Registration.isRegistration() != true) return "redirect:/login";
        ordersDAO.delete(id);
        return "redirect:/order";
    }
}

