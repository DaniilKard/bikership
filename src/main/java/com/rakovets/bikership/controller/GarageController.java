package com.rakovets.bikership.controller;

import com.rakovets.bikership.service.GarageService;
import com.rakovets.bikership.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GarageController {
    @Autowired
    private GarageService garageService;

    @PostMapping("/garage")
    public String postGarage(@RequestBody User user, Model model) {
        User savedUser = garageService.saveUser(user);
        model.addAttribute("user", user);;
        return "garage";
    }

    @GetMapping("/garage/{id}")
    public String getGarage(
            @PathVariable("id") String id,
            Model model) throws Exception {
        User user = garageService.getUser(Integer.parseInt(id));
        model.addAttribute("user", user);
        return "garage";
    }

    @PutMapping("/garage/{id}")
    public String putGarage(@RequestBody User user, @PathVariable("id") long id, Model model) {
        User currentUser = null;
        try {
            currentUser = garageService.getUser(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (currentUser != null) {
            if (user.getAge() != 0) {
                currentUser.setAge(user.getAge());
            }
            if (user.getName() != null) {
                currentUser.setName(user.getName());
            }
            if (user.getSurname() != null) {
                currentUser.setSurname(user.getSurname());
            }
        }
        User savedUser = garageService.saveUser(currentUser);
        model.addAttribute("user", currentUser);
        return "garage";
    }

    @DeleteMapping("/garage/{id}")
    public String getGarage(@PathVariable("id") long id, Model model) throws Exception {
        garageService.deleteUser(id);
        return "garage-all";
    }
}
