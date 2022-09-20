package com.cydeo.controller;

import com.cydeo.enums.Gender;
import com.cydeo.model.Mentor;
import com.cydeo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MentorController {

    @RequestMapping("/list")
    public String showTable(Model model){

//        Mentor mentor1 = new Mentor("John", "Kale", 35, Gender.MALE);
//        model.addAttribute("mentor1", mentor1);
//
//        Mentor mentor2 = new Mentor("Sarah", "Asa", 42, Gender.FEMALE);
//        model.addAttribute("mentor2", mentor2);
//
//        Mentor mentor3 = new Mentor("Liz", "Bruno", 30, Gender.FEMALE);
//        model.addAttribute("mentor3", mentor3);
//
//        Mentor mentor4 = new Mentor("Charlie", "Smith", 34, Gender.MALE);
//        model.addAttribute("mentor4", mentor4);

        List<Mentor> mentorList = new ArrayList<>();

        mentorList.add(new Mentor("John", "Kale", 35, Gender.MALE));
        mentorList.add(new Mentor("Sarah", "Asa", 23, Gender.FEMALE));
        mentorList.add(new Mentor("Liz", "Bruno", 30, Gender.FEMALE));
        mentorList.add(new Mentor("Charlie", "Smith", 34, Gender.MALE));

        model.addAttribute("mentors",mentorList);


        return "mentor/class";

    }
}
