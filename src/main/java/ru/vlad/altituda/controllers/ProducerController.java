package ru.vlad.altituda.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.vlad.altituda.JDBC.Registration;
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

    @GetMapping()
    public String index(Model model){
        if (Registration.isRegistration() != true) return "redirect:/login";
        model.addAttribute("producer", producerDAO.index());
        model.addAttribute("user",Registration.getUsers());
        return "producer/listProducer";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        if (Registration.isRegistration() != true) return "redirect:/login";
        model.addAttribute("producer", producerDAO.show(id));
        model.addAttribute("user",Registration.getUsers());
        return "redirect:/producer";
    }


    @GetMapping("/new")
    public String newPerson(@ModelAttribute("producer") Producer producer,Model model){
        if (Registration.isRegistration() != true) return "redirect:/login";
        model.addAttribute("user",Registration.getUsers());
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
        if (Registration.isRegistration() != true) return "redirect:/login";
        model.addAttribute("user",Registration.getUsers());
        model.addAttribute("producer", producerDAO.show(id));
        return "producer/edit";
    }

    @PostMapping ("/{id}")
    public String update(@ModelAttribute("producer") @Valid Producer producer,BindingResult bindingResult,
                         @PathVariable("id")int id){
        if (Registration.isRegistration() != true) return "redirect:/login";
        if (bindingResult.hasErrors()){
            return "producer/edit";
        }
        producerDAO.update(id,producer);
        return "redirect:/producer";
    }


    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id){
        if (Registration.isRegistration() != true) return "redirect:/login";
        producerDAO.delete(id);
        return "redirect:/producer";
    }
}
