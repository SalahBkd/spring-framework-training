package com.salahbkd.springboottraining;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloThymleaf {
    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("name", "salah");
        return "helloworld";
    }
}
