package com.maybach7.gweather.controllers;

import com.maybach7.gweather.models.User;
import com.maybach7.gweather.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Controller
@RequestMapping("/sign-up")
@RequiredArgsConstructor
public class SignUpController {

    private final UserService userService;
    private final Logger logger = Logger.getLogger(SignUpController.class.getName());

    @GetMapping
    public String signUpPage(Model model) {
        model.addAttribute("user", new User());
        return "sign-up";
    }

    @PostMapping
    public String signUpSubmit(@Valid @ModelAttribute User user,
                               BindingResult bindingResult,
                               Model model) {
        logger.info(user.toString());
        if(!user.getPassword().equals(user.getRepeatedPassword())) {
            bindingResult.rejectValue("repeatedPassword", null, "Пароли не совпадают");
        }
        if (bindingResult.hasErrors()) {
            return "sign-up";
        }
        var new_user = userService.registerUser(user);
        logger.info(new_user.toString());
        return "redirect:/login";
    }
}