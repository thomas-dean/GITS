package me.tomdean.gits.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthenticationController {
    @RequestMapping(value = { "/login" }, method = RequestMethod.GET)
    public String loginPage(ModelMap model) {
        return "login";
    }
}
