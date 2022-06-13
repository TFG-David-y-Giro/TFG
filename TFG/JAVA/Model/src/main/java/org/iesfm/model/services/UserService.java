package org.iesfm.model.services;

import org.iesfm.model.pojos.User;
import org.iesfm.model.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(int id) {
        if (!userRepository.existsById(id)) {
            return null;
        } else {
            return userRepository.findById(id).get();
        }
    }


    public List<String> getUsernames() {
        return userRepository.getAllUsernames();
    }

    public List<String> getMails() {
        return userRepository.getAllMails();
    }

    public List<String> getPasswords() {return userRepository.getAllPasswords();}

    public User createUser(User newUser) {
        if (userRepository.existsById(newUser.getId()) ||
                getUsernames().contains(newUser.getUsername()) ||
                getMails().contains(newUser.getMail())) {
            return null;
        } else {
            userRepository.save(newUser);
            return newUser;
        }
    }

    public User logInUser(String username, String password) {
        if (!userRepository.getAllUsernames().contains(username)) {
            return null;
        } else if (!userRepository.getAllPasswords().contains(password)) {
            return null;
        } else {
            return userRepository.getUserByUsernameAndPassword(username, password);
        }
    }

    public User updateUser(int id, User newUser) {
        if (userRepository.existsById(newUser.getId())) {
            return null;
        } else {
            User user = userRepository.findById(id).get();
            user.setName(newUser.getName());
            user.setMail(newUser.getMail());
            user.setUsername(newUser.getUsername());
            user.setPassword(newUser.getPassword());
            user.setSurname(newUser.getSurname());
            userRepository.save(user);
            return user;
        }
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
