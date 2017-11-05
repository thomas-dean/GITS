package me.tomdean.gits.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
    @RequestMapping(value = { "/" }, method = RequestMethod.GET)
    public String indexPage(ModelMap model) {
        model.addAttribute("greeting", "Welcome to GITS");
        return "welcome";
    }
}
