package ma.quantorion.appquitue.condamnationrest.domain.exception;

public class CondamnationNotFoundException extends RuntimeException
{
	public CondamnationNotFoundException(Long id)
	{
		super("Couldn't find Condamnation " + id);
	}
}
