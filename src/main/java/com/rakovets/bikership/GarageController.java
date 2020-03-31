package com.rakovets.bikership;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class GarageController {
    @Autowired
    private GarageService garageService;

    @GetMapping("/garage/{name}/{surname}/{age}")
    public String getGarage(
            @PathVariable("name") String name,
            @PathVariable("surname") String surname,
            @PathVariable("age") String age,
                            Model model) {
        User user = new User(name, surname, Integer.parseInt(age));
        User savedUser = garageService.saveUser(user);
        model.addAttribute("name", name);
        model.addAttribute("surname", surname);
        model.addAttribute("age", age);
        return "garage";
    }

    @GetMapping("/garage/{id}")
    public String getGarage(
            @PathVariable("id") String id,
            Model model) throws Exception {
        User user = garageService.getUser(Integer.parseInt(id));
        model.addAttribute("id", id);
        return "garage";
    }
}
