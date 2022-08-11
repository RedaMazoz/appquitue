package ma.quantorion.appquitue.exception;

public class PunishmentNotFoundException extends RuntimeException
{
	public PunishmentNotFoundException(Long id)
	{
		super("Couldn't find Punishment " + id);
	}
}
