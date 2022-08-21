package ma.quantorion.appquitue.diplomarest.domain.exception;

public class DiplomaNotFoundException extends RuntimeException
{
	public DiplomaNotFoundException(Long id)
	{
		super("Couldn't find Diploma " + id);
	}
}
