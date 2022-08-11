package ma.quantorion.appquitue.exception;

public class InternshipNotFoundException extends RuntimeException
{
	public InternshipNotFoundException(Long id)
	{
		super("Couldn't find Internship " + id);
	}
}
