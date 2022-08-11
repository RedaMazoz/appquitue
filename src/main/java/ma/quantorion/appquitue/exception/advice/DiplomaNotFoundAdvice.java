package ma.quantorion.appquitue.exception.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import ma.quantorion.appquitue.exception.DiplomaNotFoundException;

@ControllerAdvice
public class DiplomaNotFoundAdvice
{

	@ResponseBody
	@ExceptionHandler(DiplomaNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String PersonalNotFoundHandler(DiplomaNotFoundException ex)
	{
		return ex.getMessage();
	}
}
