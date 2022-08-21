package ma.quantorion.appquitue.missionrest.domain.exception;

public class MissionNotFoundException extends RuntimeException
{
	public MissionNotFoundException(Long id)
	{
		super("Couldn't find Mission " + id);
	}
}
