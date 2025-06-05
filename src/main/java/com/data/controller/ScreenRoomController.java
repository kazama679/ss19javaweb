package com.data.controller;

import com.data.entity.ScreenRoom;
import com.data.service.ScreenRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/screenroom")
public class ScreenRoomController {

    @Autowired
    private ScreenRoomService screenRoomService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("rooms", screenRoomService.findAll());
        return "screenroom/list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("room", new ScreenRoom());
        return "screenroom/form";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("room") ScreenRoom room, BindingResult result) {
        if (room.getCapacity() <= 0) {
            result.rejectValue("capacity", "error.capacity", "Sức chứa phải > 0");
        }
        if (result.hasErrors()) {
            return "screenroom/form";
        }
        screenRoomService.save(room);
        return "redirect:/screenroom/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("room", screenRoomService.findById(id));
        return "screenroom/form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        screenRoomService.delete(id);
        return "redirect:/screenroom/list";
    }
}
