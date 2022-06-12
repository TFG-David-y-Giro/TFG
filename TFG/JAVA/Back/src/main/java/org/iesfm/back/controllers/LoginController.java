package org.iesfm.back.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    public LoginController() {
    }


    @GetMapping("/login")
    public String login() {
        return "login";
    }
}