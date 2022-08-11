package ma.quantorion.appquitue.exception;

public class InjuryNotFoundException extends RuntimeException
{
	public InjuryNotFoundException(Long id)
	{
		super("Couldn't find Injury " + id);
	}
}
