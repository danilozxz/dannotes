package com.dannotes.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dannotes.demo.model.User;
import com.dannotes.demo.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User insertUser(User user) {
        return userRepository.save(user);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findUserById(Long id) {
        Optional<User> Opuser = userRepository.findById(id);

        if (Opuser.isEmpty()) {
            System.out.println("Usuário não encontrado");
        }
        return userRepository.findById(id);
    }

    public void deleteUserById(Long id) {
        if (!userRepository.existsById(id)) {
            System.out.println("Usuário não encontrado");
        }

        userRepository.deleteById(id);
    }

    public User updateUser(Long id, User userDetails) {
        Optional<User> opUser = userRepository.findById(id);
        
        if(opUser.isEmpty()) {
            System.out.println("Usuário não encontrado");
        }  

        User user = opUser.get();
        user.setName(userDetails.getName());
        return userRepository.save(user);
    }
}
