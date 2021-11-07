package com.salahbkd.springboottraining;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {
    @GetMapping("/")
    public String showHome() {
        return "hello world Spring Boot !";
    }
}
