package ma.quantorion.appquitue.domain.interfaces;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

import ma.quantorion.appquitue.model.Injury;

public interface InjuryService
{
	public abstract ResponseEntity<?> addInjury(Injury Injury);
	public abstract EntityModel<Injury> getInjury(Long id);
	public abstract CollectionModel<EntityModel<Injury>> getInjurys();
	public abstract ResponseEntity<?> updateInjury(Long id, Injury nouveauInjury);
	public abstract ResponseEntity<?> deleteInjury(Long id);
}
