package com.kolu.JobApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JobController {

    @RequestMapping({"/", "/home"})
    public String home() {
        System.out.println("into Home Page");
        return "home";
    }

    @RequestMapping("/addjob")
    public String addJob() {
        return "addjob";
    }
}
