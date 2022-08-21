package ma.quantorion.appquitue.personalrest.domain.exception;

public class PersonalNotFoundException extends RuntimeException
{
	public PersonalNotFoundException(Long id)
	{
		super("Couldn't find Personal " + id);
	}
}
