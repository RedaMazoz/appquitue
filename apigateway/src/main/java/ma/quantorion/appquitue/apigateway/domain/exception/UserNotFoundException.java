package ma.quantorion.appquitue.apigateway.domain.exception;

public class UserNotFoundException extends RuntimeException
{
	public UserNotFoundException(Long id)
	{
		super("Couldn't find Condamnation " + id);
	}
}
