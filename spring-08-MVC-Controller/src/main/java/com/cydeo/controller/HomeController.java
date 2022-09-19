package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller//it has @Component
public class HomeController {


    @RequestMapping("/home") //define end point
    public String home(){ //method name can be anything
        return "home.html"; //view info needs to be return from method
    }

    @RequestMapping("/mizgin")
    public String home2(){
        return "home.html";
    }

    @RequestMapping//nothing or /
    public String home3(){
        return "home.html";
    }

    @RequestMapping({"/apple", "/orange"})
    public String home4(){
        return "home.html";
    }

}
