package com.maybach7.gweather.controllers;

import com.maybach7.gweather.dto.PasswordChangeForm;
import com.maybach7.gweather.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final UserService userService;

    @GetMapping
    public String profilePage(Model model,
                              Principal principal) {
        model.addAttribute("passwordForm", new PasswordChangeForm());
        return "profile";
    }

    @PostMapping("/change-password")
    public String changePassword(@ModelAttribute("passwordForm") PasswordChangeForm form,
                                 BindingResult bindingResult,
                                 Principal principal,
                                 RedirectAttributes redirectAttributes) {
        if(!userService.checkPassword(principal.getName(), form.getCurrentPassword())) {
            bindingResult.rejectValue("currentPassword", null, "Неверный пароль");
        }
        if(!form.getNewPassword().equals(form.getRepeatedNewPassword())) {
            bindingResult.rejectValue("repeatedNewPassword", null, "Пароли не совпадают");
        }
        if(bindingResult.hasErrors()) {
            return "profile";
        }

        // update user with new password
        var user = userService.findByUsername(principal.getName());
        userService.changePassword(user.get(), form.getNewPassword());

        return "redirect:/profile";
    }
}