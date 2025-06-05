package com.data.controller;

import com.data.entity.Theater;
import com.data.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/theater")
public class TheaterController {

    @Autowired
    private TheaterService service;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("theaters", service.getAll());
        return "theater/list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("theater", new Theater());
        return "theater/form";
    }

    @PostMapping("/add")
    public String save(@Valid @ModelAttribute("theater") Theater theater,
                       BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "theater/form";
        }
        service.save(theater);
        return "redirect:/theater/list";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("theater", service.getById(id));
        return "theater/form";
    }

    @PostMapping("/edit")
    public String update(@Valid @ModelAttribute("theater") Theater theater,
                         BindingResult result) {
        if (result.hasErrors()) {
            return "theater/form";
        }
        service.update(theater);
        return "redirect:/theater/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/theater/list";
    }
}