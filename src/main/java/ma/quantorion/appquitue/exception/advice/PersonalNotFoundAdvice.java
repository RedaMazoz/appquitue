package ma.quantorion.appquitue.exception.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import ma.quantorion.appquitue.exception.PersonalNotFoundException;

@ControllerAdvice
public class PersonalNotFoundAdvice
{

	@ResponseBody
	@ExceptionHandler(PersonalNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String PersonalNotFoundHandler(PersonalNotFoundException ex)
	{
		return ex.getMessage();
	}
}
