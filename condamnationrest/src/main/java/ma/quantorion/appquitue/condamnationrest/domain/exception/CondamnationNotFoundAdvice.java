package ma.quantorion.appquitue.condamnationrest.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CondamnationNotFoundAdvice
{

	@ResponseBody
	@ExceptionHandler(CondamnationNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String CondamnationNotFoundHandler(CondamnationNotFoundException ex)
	{
		return ex.getMessage();
	}
}
