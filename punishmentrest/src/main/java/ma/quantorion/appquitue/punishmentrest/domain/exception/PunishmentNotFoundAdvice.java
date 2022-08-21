package ma.quantorion.appquitue.punishmentrest.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PunishmentNotFoundAdvice
{

	@ResponseBody
	@ExceptionHandler(PunishmentNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String PunishmentNotFoundHandler(PunishmentNotFoundException ex)
	{
		return ex.getMessage();
	}
}
