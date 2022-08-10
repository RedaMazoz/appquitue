package ma.quantorion.appquitue.exception;

public class PersonalNotFoundException extends RuntimeException
{
	public PersonalNotFoundException(Long id)
	{
		super("Couldn't find Personal " + id);
	}
}
