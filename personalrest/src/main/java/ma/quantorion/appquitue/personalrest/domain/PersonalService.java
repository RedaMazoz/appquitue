package ma.quantorion.appquitue.personalrest.domain;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

public interface PersonalService
{
	public abstract ResponseEntity<?> addPersonal(Personal Personal);
	public abstract EntityModel<Personal> getPersonal(Long id);
	public abstract String getPersonalBasic(Long id);
	public abstract CollectionModel<EntityModel<Personal>> getPersonals();
	public abstract ResponseEntity<?> updatePersonal(Long id, Personal nouveauPersonal);
	public abstract ResponseEntity<?> deletePersonal(Long id);
	
}
