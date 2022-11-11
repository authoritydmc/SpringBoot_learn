package com.authoritydmc.learn.annotations;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.PARAMETER,ElementType.FIELD} )
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = AgeValidator.class)
public @interface AgeChecker {
    public String message() default "Invalid Age:Age should be greater than 5";

  public  int age() default 18;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}
