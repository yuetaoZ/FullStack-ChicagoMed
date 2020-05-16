package edu.depaul.cdm.se.chicagomed.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;




@Controller

public class HomePageController {

    @GetMapping("/home")
    public String index(Model model) {
        return "home";
    }
    @GetMapping("/admin")
    public String Admin(Model model){

        return "Admin";
    }
    @GetMapping("/Doctor")
    public String Doctor(Model model){
        return "Doctor";
    }
    @GetMapping("/patient")
        public String Patient(Model model){
        return "patient";
    }







}
