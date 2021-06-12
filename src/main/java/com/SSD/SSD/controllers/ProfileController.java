package com.SSD.SSD.controllers;

import com.SSD.SSD.model.Student;
import com.SSD.SSD.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController

public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @PostMapping("/saveProfile")
    public String saveStudent(@ModelAttribute("student") Student student){
        profileService.saveStudent(student);
        return "redirect:/";
    }


    @RequestMapping("/profile/{id}")
    public String ProfileModel_index(@PathVariable("id") Integer id, Model model){

        Student student = profileService.getStudentById(id);
        model.addAttribute("hey", student);
        return "profile";

    }

    @GetMapping("/profile/{id}")
    public ModelAndView ProfileModel(@PathVariable (value="id") Integer id, Model model){

        ModelAndView mav = new ModelAndView("profile");

        Student ss = profileService.getStudentById(id);
        mav.addObject("studentprofile", ss);
        return mav;
    }

}
