package ru.springProject.service;

import ru.springProject.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    void save(User user);

    User getById(int id);

    void update(User user,int id);

    void delete(int id);
}
