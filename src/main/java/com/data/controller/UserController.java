package com.data.controller;

import com.data.entity.User;
import com.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String listUsers(Model model,
                            @RequestParam(defaultValue = "1") int page) {
        int size = 5;
        List<User> users = userService.getUsers(page, size);
        long totalUsers = userService.countUsers();
        int totalPages = (int) Math.ceil((double) totalUsers / size);

        model.addAttribute("users", users);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        return "user/user_list";
    }

    @PostMapping("/toggle/{id}")
    public String toggleUserStatus(@PathVariable Long id,
                                   @RequestParam int currentPage) {
        userService.toggleUserActive(id);
        return "redirect:/admin/users?page=" + currentPage;
    }


}
