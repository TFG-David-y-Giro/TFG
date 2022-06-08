package org.iesfm.model.services;

import org.iesfm.model.pojos.User;
import org.iesfm.model.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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
            return  userRepository.getById(id);
        }
    }

    public User createUser(User newUser) {
        if (!userRepository.existsById(newUser.getId())) {
            return null;
        } else {
            userRepository.save(newUser);
            return newUser;
        }
    }
}
