package ma.quantorion.appquitue.internshiprest.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class InternshipNotFoundAdvice
{

	@ResponseBody
	@ExceptionHandler(InternshipNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String InternshipNotFoundHandler(InternshipNotFoundException ex)
	{
		return ex.getMessage();
	}
}
