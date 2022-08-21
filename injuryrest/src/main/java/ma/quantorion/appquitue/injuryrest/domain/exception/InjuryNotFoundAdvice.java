package ma.quantorion.appquitue.injuryrest.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class InjuryNotFoundAdvice
{

	@ResponseBody
	@ExceptionHandler(InjuryNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String InjuryNotFoundHandler(InjuryNotFoundException ex)
	{
		return ex.getMessage();
	}
}
