package ru.springProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.springProject.model.User;

@Repository
public interface UserRepositories extends JpaRepository<User, Integer> {
}
