package org.poz.anton.SpringSecurityApp.service;

import org.poz.anton.SpringSecurityApp.model.User;

/**
 * Service class for {@link User}
 * @author Pozdnyakov Anton
 * @version 1.0
 * */

public interface UserService {
    void save(User user);

    User findByUserName(String username);
}
