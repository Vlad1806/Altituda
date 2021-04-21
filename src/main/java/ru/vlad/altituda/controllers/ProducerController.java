package ru.vlad.altituda.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.vlad.altituda.Model.Producer;
import ru.vlad.altituda.dao.ProducerDAO;

import javax.validation.Valid;

@Controller
@RequestMapping("/producer")
public class ProducerController {
    @Autowired
    private final ProducerDAO producerDAO;

    public ProducerController(ProducerDAO producerDAO) {
        this.producerDAO = producerDAO;
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
        model.addAttribute("producer", producerDAO.index());
        return "producer/listProducer";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("producer", producerDAO.show(id));
        return "redirect:/producer";
    }


    @GetMapping("/new")
    public String newPerson(@ModelAttribute("producer") Producer producer){
        return "producer/new";
    }


    @PostMapping()
    public String create(@ModelAttribute("producer") @Valid Producer producer,
                         BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "producer/new";
        }
        producerDAO.save(producer);
        return "redirect:/producer";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("producer", producerDAO.show(id));
        return "producer/edit";
    }

    @PostMapping ("/{id}")
    public String update(@ModelAttribute("producer") @Valid Producer producer,BindingResult bindingResult,
                         @PathVariable("id")int id){
        if (bindingResult.hasErrors()){
            return "producer/edit";
        }
        producerDAO.update(id,producer);
        return "redirect:/producer";
    }


    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id){
        producerDAO.delete(id);
        return "redirect:/producer";
    }
}
