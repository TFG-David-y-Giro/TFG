package org.iesfm.back.controllers;

import org.iesfm.model.pojos.User;
import org.iesfm.model.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

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
        if (userService.getUser(newUser.getId()) != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Ya existía el id");
        } else if (userService.getUsernames().contains(newUser.getUsername())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ya existía el nombre de usuario");
        } else if (userService.getMails().contains(newUser.getMail())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Ya existía el mail");
        } else {
            userService.createUser(newUser);
            return newUser;
        }
    }

    @GetMapping("/user")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") int id) {
        return userService.getUser(id);
    }

    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable("id") int id, @RequestBody User newUser) {
        if (userService.getUser(id) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe");
        } else {
            return userService.updateUser(id, newUser);
        }
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
    }
}
