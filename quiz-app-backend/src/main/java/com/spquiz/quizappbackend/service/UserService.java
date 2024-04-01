package com.spquiz.quizappbackend.service;

import com.spquiz.quizappbackend.model.User;
import com.spquiz.quizappbackend.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository ;

    @Transactional
    public void saveUser(User user){
        userRepository.save(user);
    }
    @Transactional
    public User getUser(Long id){
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }
}
