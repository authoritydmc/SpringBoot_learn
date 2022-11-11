package com.authoritydmc.learn.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<AgeChecker,Integer> {
    int ageVa=0;
    @Override
    public void initialize(AgeChecker constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        ageVa=constraintAnnotation.age();

    }

    @Override
    public boolean isValid(Integer age, ConstraintValidatorContext constraintValidatorContext) {


        return age>ageVa;
    }
}
