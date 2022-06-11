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

    public User createUser(User newUser) {
        if (!userRepository.existsById(newUser.getId())) {
            userRepository.save(newUser);
            return newUser;
        } else {
            return null;
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
