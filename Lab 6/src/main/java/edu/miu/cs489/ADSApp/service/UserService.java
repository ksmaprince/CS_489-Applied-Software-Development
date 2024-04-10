package edu.miu.cs489.ADSApp.service;

import edu.miu.cs489.ADSApp.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    List<User> getAllUsers();

    User getUserById(Integer userId);

    User updateUser(User user);

    void deleteUserById(Integer userId);
}
