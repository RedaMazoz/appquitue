package ma.quantorion.appquitue.missionrest.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MissionNotFoundAdvice
{

	@ResponseBody
	@ExceptionHandler(MissionNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String MissionNotFoundHandler(MissionNotFoundException ex)
	{
		return ex.getMessage();
	}
}
