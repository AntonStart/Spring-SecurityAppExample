package org.poz.anton.SpringSecurityApp.dao;

import org.poz.anton.SpringSecurityApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
    User findByUserName(String username);
}
