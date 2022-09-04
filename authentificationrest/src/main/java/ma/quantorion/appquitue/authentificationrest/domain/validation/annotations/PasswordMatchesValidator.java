package ma.quantorion.appquitue.authentificationrest.domain.validation.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import ma.quantorion.appquitue.authentificationrest.domain.User;

public class PasswordMatchesValidator
implements ConstraintValidator<PasswordMatches, Object> {
  
  @Override
  public void initialize(PasswordMatches constraintAnnotation) {
  }
  @Override
  public boolean isValid(Object obj, ConstraintValidatorContext context){
      User user = (User) obj;
      return user.getPassword().equals(user.getMatchingPassword());
  }
}