package com.intellect.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.intellect.model.User;

@Component("beforeUserValidation")
class UserValidation implements Validator {
	 
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }
 
    @Override
    public void validate(Object obj, Errors errors) {
        User user = (User) obj;
        if (checkInputString(user.getfName())) {
            errors.rejectValue("First Name", "name.empty");
        }
        if (checkInputString(user.getPinCode()+"")) {
            errors.rejectValue("Pin Code", "pinCode.empty");
        }
        if (checkInputString(user.getBirthDate().toString())) {
            errors.rejectValue("Birth Date", "birthDate.empty");
        }
        if (checkInputString(user.getEmail())) {
            errors.rejectValue("Email", "email.empty");
        }
    }
 
    private boolean checkInputString(String input) {
        return (input == null || input.trim().length() == 0);
    }
}
