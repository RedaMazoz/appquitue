package ma.quantorion.appquitue.permissionrest.domain.exception;

public class PermissionNotFoundException extends RuntimeException
{
	public PermissionNotFoundException(Long id)
	{
		super("Couldn't find Permission " + id);
	}
}
