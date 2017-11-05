package me.tomdean.gits.daos;

import me.tomdean.gits.models.User;

public interface UserDao {
    void save(User user);
    void delete(User user);
    User findById(Long id);
    User findByUserName(String userName);
}
