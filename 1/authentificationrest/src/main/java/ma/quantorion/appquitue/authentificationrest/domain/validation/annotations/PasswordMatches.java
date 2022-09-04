
package ma.quantorion.appquitue.authentificationrest.domain.validation.annotations;

import java.lang.annotation.*;

import javax.validation.Constraint;
import javax.validation.Payload;


@Target({ElementType.TYPE,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordMatchesValidator.class)
@Documented
public @interface PasswordMatches {
    String message() default "Passwords don't match";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}