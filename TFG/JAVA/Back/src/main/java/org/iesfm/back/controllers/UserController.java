package org.iesfm.back.controllers;

import org.iesfm.model.pojos.User;
import org.iesfm.model.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public User postUser(@RequestBody User newUser)  {
        if (userService.getUser(newUser.getId()) == null) {
            userService.createUser(newUser);
            return newUser;
        } else {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Ya existía");
        }
    }
}
