package ma.quantorion.appquitue.exception;

public class PersonnelNotFoundException extends RuntimeException
{
	public PersonnelNotFoundException(Long id)
	{
		super("Couldn't find personnel " + id);
	}
}
