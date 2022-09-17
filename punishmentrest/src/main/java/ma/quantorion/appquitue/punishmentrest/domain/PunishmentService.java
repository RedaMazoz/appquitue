package ma.quantorion.appquitue.punishmentrest.domain;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

public interface PunishmentService
{
	public abstract ResponseEntity<?> addPunishment(Punishment Punishment);
	public abstract EntityModel<Punishment> getPunishment(Long id);
	public abstract CollectionModel<EntityModel<Punishment>> getPunishments();
	public abstract ResponseEntity<?> updatePunishment(Long id, Punishment nouveauPunishment);
	public abstract ResponseEntity<?> deletePunishment(Long id);
	
}
