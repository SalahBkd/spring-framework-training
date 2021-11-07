package com.salahbkd.springsecuritytraining;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {

    @GetMapping("/")
    public String showHome() {
        return ("<h1>home</h1>");
    }

    @GetMapping("/user")
    public String showUserPage() {
        return ("<h1>user page</h1>");
    }

    @GetMapping("/admin")
    public String showAdminPage() {
        return ("<h1>admin page</h1>");
    }
}
