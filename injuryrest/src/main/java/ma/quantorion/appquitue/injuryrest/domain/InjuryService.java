package ma.quantorion.appquitue.injuryrest.domain;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

public interface InjuryService
{
	public abstract ResponseEntity<?> addInjury(Injury Injury);
	public abstract EntityModel<Injury> getInjury(Long id);
	public abstract CollectionModel<EntityModel<Injury>> getInjurys();
	public abstract ResponseEntity<?> updateInjury(Long id, Injury nouveauInjury);
	public abstract ResponseEntity<?> deleteInjury(Long id);
	
}
