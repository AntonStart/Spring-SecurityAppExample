package org.poz.anton.SpringSecurityApp.service;

/**
 * Service for Security.
 * @author Pozdnyakov Anton
 * @version 1.0
 * */


public interface SecurityService {
    String findLoggedInUsername();
    void autoLogin(String username, String password);
}
