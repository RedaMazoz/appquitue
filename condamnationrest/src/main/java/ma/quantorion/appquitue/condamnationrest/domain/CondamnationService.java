package ma.quantorion.appquitue.condamnationrest.domain;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

public interface CondamnationService
{
	public abstract ResponseEntity<?> addCondamnation(Condamnation Condamnation);
	public abstract EntityModel<Condamnation> getCondamnation(Long id);
	public abstract CollectionModel<EntityModel<Condamnation>> getCondamnations();
	public abstract ResponseEntity<?> updateCondamnation(Long id, Condamnation nouveauCondamnation);
	public abstract ResponseEntity<?> deleteCondamnation(Long id);
	
}
