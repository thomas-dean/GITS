package me.tomdean.gits.services;

import me.tomdean.gits.models.User;

public interface UserService {
    void save(User user);
    void delete(User user);
    User findById(Long id);
    User findByUserName(String userName);
}
