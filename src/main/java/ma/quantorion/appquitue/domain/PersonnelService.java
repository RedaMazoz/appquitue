package ma.quantorion.appquitue.domain;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

import ma.quantorion.appquitue.model.Personnel;

public interface PersonnelService
{
	public abstract ResponseEntity<?> addPersonnel(Personnel personnel);
	public abstract EntityModel<Personnel> getPersonnel(Long id);
	public abstract String getPersonnelBasic(Long id);
	public abstract CollectionModel<EntityModel<Personnel>> getPersonnels();
	public abstract ResponseEntity<?> updatePersonnel(Long id, Personnel nouveauPersonnel);
	public abstract ResponseEntity<?> deletePersonnel(Long id);
	
}
