package com.salahbkd.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class HomeServlet {
    @RequestMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("person", new Person());
        return "form";
    }

   // @RequestMapping("/processForm")
    // Data binding with @RequestParam
    /*public String postForm(@RequestParam("theName") String name, Model model) {
        model.addAttribute("theName", name);
        return "formresults";
    }*/

    // Data binding with spring mvc form tags
    /*@RequestMapping("/processForm")
    public String postForm(@ModelAttribute("person") Person person) {
        System.out.println(person.getName());
        return "formresults";
    }*/

    // Validation
    @RequestMapping("/processForm")
    public String postForm(@Valid @ModelAttribute("person") Person person,
                           BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return "form";
        else
            return "formresults";
    }
}
