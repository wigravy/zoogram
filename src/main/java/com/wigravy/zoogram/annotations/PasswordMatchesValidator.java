package com.wigravy.zoogram.annotations;

import com.wigravy.zoogram.payload.request.RegistrationNewUserRequest;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {
    @Override
    public void initialize(PasswordMatches constraintAnnotation) {

    }

    @Override
    public boolean isValid(final Object obj, final ConstraintValidatorContext context) {
        RegistrationNewUserRequest request = (RegistrationNewUserRequest) obj;
        return request.getPassword().equals(request.getConfirmPassword());
    }
}
