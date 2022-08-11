package ma.quantorion.appquitue.exception;

public class DiplomaNotFoundException extends RuntimeException
{
	public DiplomaNotFoundException(Long id)
	{
		super("Couldn't find Diploma " + id);
	}
}
