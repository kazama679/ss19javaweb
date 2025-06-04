package com.data.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/users")
public class UserController {

    @GetMapping
    public String listUsers(Model model,
                            @RequestParam(defaultValue = "1") int page) {
        return "user/user_list";
    }

}
