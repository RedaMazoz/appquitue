package ma.quantorion.appquitue.diplomarest.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class DiplomaNotFoundAdvice
{

	@ResponseBody
	@ExceptionHandler(DiplomaNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String DiplomaNotFoundHandler(DiplomaNotFoundException ex)
	{
		return ex.getMessage();
	}
}
