package org.poz.anton.SpringSecurityApp.service;

import org.poz.anton.SpringSecurityApp.dao.RoleDao;
import org.poz.anton.SpringSecurityApp.dao.UserDao;
import org.poz.anton.SpringSecurityApp.model.Role;
import org.poz.anton.SpringSecurityApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Implementation for {@link UserService} interface
 * @author Pozdnyakov Anton
 * @version 1.0
 * */

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.getOne(1L));
        user.setRoles(roles);
        userDao.save(user);
    }

    @Override
    public User findByUserName(String username) {
        return userDao.findByUserName(username);
    }
}
