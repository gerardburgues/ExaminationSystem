package com.SSD.SSD.controllers;

import com.SSD.SSD.model.Student;
import com.SSD.SSD.model.Users;
import com.SSD.SSD.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController

public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @PostMapping("/saveProfile")
    public String saveUser(@ModelAttribute("student") Users user){
        profileService.saveUser(user);
        return "redirect:/";
    }


    @RequestMapping("/profile/{id}")
    public String ProfileModel_index(@PathVariable("id") Integer id, Model model){

        Users user = profileService.getUserById(id);
        model.addAttribute("hey", user);
        return "profile";

    }


    @GetMapping("/profile/{id}")
    public ModelAndView ProfileModel(@PathVariable (value="id") Integer id, Model model){

        ModelAndView mav = new ModelAndView("profile");

        Users ss = profileService.getUserById(id);
        mav.addObject("studentprofile", ss);
        return mav;
    }



}
