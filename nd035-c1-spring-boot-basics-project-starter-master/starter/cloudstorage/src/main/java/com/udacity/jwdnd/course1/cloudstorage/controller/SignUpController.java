package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.ui.Model;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
public class SignUpController {
    private final UserService userService;

    public SignUpController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String signupView() {
        return "signup";
    }

    @PostMapping
    public String signupUser(@ModelAttribute User user, Model model) {
        String signUpError = null;

        if (userService.isUsernameAvailable(user.getUsername())) {
            signUpError = "The username already exists.";
        }

        if (signUpError == null) {
            int rowsAdd = userService.createUser(user);
            if (rowsAdd < 0) {
                signUpError = "There is an error when signing you up.";
            }
            model.addAttribute("signuoSuccess", true);
        } else {
            model.addAttribute("signUpError",signUpError);
        }

        return "signup";

    }
}
