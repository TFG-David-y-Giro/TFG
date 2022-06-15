package org.iesfm.back.controllers;

import org.iesfm.model.pojos.User;
import org.iesfm.model.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
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

    @GetMapping(value ="/user/login", params = {"username", "password"})
    public User logIn(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        if (!userService.getUsernames().contains(username)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No está registrado");
        } else if (!userService.getPasswords().contains(password)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "No cuadra con tu usuario");
        } else {
            return userService.logInUser(username, password);
        }
    }

    @GetMapping("/user")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/user/usernames")
    public List<String> getUsernames() {return userService.getUsernames();}

    @GetMapping("/user/mails")
    public List<String> getMails() {return userService.getMails();}

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
