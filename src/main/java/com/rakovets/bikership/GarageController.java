package com.rakovets.bikership;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class GarageController {
    @GetMapping("/garage/{login}")
    public String getGarage(@PathVariable("login") String login, Model model) {
        model.addAttribute("name", login);
        return "garage";
    }
}
