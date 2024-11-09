package ru.springProject.service;

import org.springframework.stereotype.Service;
import ru.springProject.model.User;
import ru.springProject.repositories.UserRepositories;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepositories userRepositories;

    public UserServiceImpl(UserRepositories userRepositories) {
        this.userRepositories = userRepositories;
    }

    @Override
    public List<User> getUsers() {
        return userRepositories.findAll();
    }

    @Override
    public void save(User user) {
        userRepositories.save(user);
    }

    @Override
    public User getById(int id) {
        Optional<User> optional = userRepositories.findById(id);
        return optional.orElse(null);
    }

    @Override
    public void update(User user,int id) {
        user.setId(id);
        userRepositories.save(user);
    }

    @Override
    public void delete(int id) {
        userRepositories.deleteById(id);
    }
}
