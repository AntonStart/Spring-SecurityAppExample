package org.poz.anton.SpringSecurityApp.validator;

import org.poz.anton.SpringSecurityApp.model.User;
import org.poz.anton.SpringSecurityApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Validator for {@link org.poz.anton.SpringSecurityApp.model.User} class,
 * implements {@link Validator}
 * @author Pozdnyakov Anton
 * @version 1.0
 * */

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "Required");

        if (user.getUserName().length() < 8 || user.getUserName().length()>32) {
            errors.rejectValue("username", "Size.loginForm.username");
        }

        if (userService.findByUserName(user.getUserName())!=null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");
        if (user.getPassword().length()<8 || user.getPassword().length()>32) {
            errors.rejectValue("password","Size.userForm.password");
        }

        if (!user.getConfirmPassword().equals(user.getPassword())){
            errors.rejectValue("confirmPassword","Different.userForm.password");
        }
    }
}
