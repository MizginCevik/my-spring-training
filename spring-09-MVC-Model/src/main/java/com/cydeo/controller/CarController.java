package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarController {

    //*****(QUERY PARAMETER)
    @RequestMapping("/info") //write this localhost:8080/info?make=Tesla on browser (QUERY PARAMETER)
    public String carInfo(@RequestParam String make, Model model){

        model.addAttribute("make", make);


        return "car/car-info";
    }

    //*****(QUERY PARAMETER)
    @RequestMapping("/info2") //write this localhost:8080/info2 -> (KIA) (QUERY PARAMETER)
    public String carInfo2(@RequestParam(value = "make", required = false, defaultValue = "KIA") String make, Model model){

        model.addAttribute("make", make);


        return "car/car-info";
    }

    //*****(QUERY PARAMETER)
    @RequestMapping("/info3") //write this localhost:8080/info3?make=Tesla&year=2020 on browser
    public String carInfo3(@RequestParam String make, @RequestParam int year, Model model){

        model.addAttribute("make", make);
        model.addAttribute("year", year);


        return "car/car-info";
    }

    //*****(PATH VARIABLE)
    @RequestMapping("/info/{make}/{year}") //localhost:8080/info/honda/2015
    public String getCarInfo(@PathVariable String make, @PathVariable int year){

        System.out.println(make);
        System.out.println(year);
        return "car/car-info";
    }
}
