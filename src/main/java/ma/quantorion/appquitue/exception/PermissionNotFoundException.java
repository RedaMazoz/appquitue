package ma.quantorion.appquitue.exception;

public class PermissionNotFoundException extends RuntimeException
{
	public PermissionNotFoundException(Long id)
	{
		super("Couldn't find Permission " + id);
	}
}
