package com.SSD.SSD.controllers;

import com.SSD.SSD.model.MyUserDetails;
import com.SSD.SSD.model.Users;
import com.SSD.SSD.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController

public class ProfileController {

    @Autowired
    private UsersService userService;

    @RequestMapping("/professor/profile")
    public ModelAndView displayProfessorProfile(){
        MyUserDetails principal = (MyUserDetails) SecurityContextHolder .getContext().getAuthentication().getPrincipal();
        ModelAndView mav =  new ModelAndView("professorProfile");
        Users user = userService.findUserById(principal.getUserId());
        mav.addObject("profile", user);
        return mav ;

    }
    @RequestMapping("/profile")
    public ModelAndView displayStudentProfile(){
        MyUserDetails principal = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ModelAndView mav =  new ModelAndView("profile");
        Users user = userService.findUserById(principal.getUserId());
        mav.addObject("studentprofile", user);
        return mav ;

    }

//    @PostMapping("/saveProfile")
//    public String saveUser(@ModelAttribute("student") Users user){
//        userService.saveUser(user);
//        return "redirect:/";
//    }
//
//    @RequestMapping("/profile/{id}")
//    public String ProfileModel_index(@PathVariable("id") Integer id, Model model){
//
//        Users user = userService.findUserById(id);
//        model.addAttribute("hey", user);
//        return "profile";
//
//    }
//
//    @GetMapping("/profile/{id}")
//    public ModelAndView ProfileModel(@PathVariable (value="id") Integer id, Model model){
//
//        ModelAndView mav = new ModelAndView("profile");
//
//        Users ss = userService.findUserById(id);
//        mav.addObject("studentprofile", ss);
//        return mav;
//    }
}
