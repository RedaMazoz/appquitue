package ma.quantorion.appquitue.internshiprest.domain.exception;

public class InternshipNotFoundException extends RuntimeException
{
	public InternshipNotFoundException(Long id)
	{
		super("Couldn't find Internship " + id);
	}
}
