package edu.miu.cs489.ADSApp.service.impl;

import edu.miu.cs489.ADSApp.model.User;
import edu.miu.cs489.ADSApp.repository.UserRepository;
import edu.miu.cs489.ADSApp.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Integer userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(Integer userId) {
        userRepository.deleteById(userId);
    }
}
