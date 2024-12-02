package ru.romanchev.tacocloud.web.repository;

import org.springframework.data.repository.CrudRepository;
import ru.romanchev.tacocloud.web.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
