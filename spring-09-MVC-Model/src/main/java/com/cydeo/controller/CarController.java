package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarController {

    @RequestMapping("/info") //write this localhost:8080/info?make=Tesla on browser
    public String carInfo(@RequestParam String make, Model model){

        model.addAttribute("make", make);


        return "car/car-info";
    }

    @RequestMapping("/info2") //write this localhost:8080/info2 -> (KIA)
    public String carInfo2(@RequestParam(value = "make", required = false, defaultValue = "KIA") String make, Model model){

        model.addAttribute("make", make);


        return "car/car-info";
    }

    @RequestMapping("/info3") //write this localhost:8080/info3?make=Tesla&year=2020 on browser
    public String carInfo3(@RequestParam String make, @RequestParam int year, Model model){

        model.addAttribute("make", make);
        model.addAttribute("year", year);


        return "car/car-info";
    }
}
