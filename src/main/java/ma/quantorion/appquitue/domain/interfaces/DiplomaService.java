package ma.quantorion.appquitue.domain.interfaces;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

import ma.quantorion.appquitue.model.Diploma;

public interface DiplomaService
{
	public abstract ResponseEntity<?> addDiploma(Diploma Diploma);
	public abstract EntityModel<Diploma> getDiploma(Long id);
	public abstract CollectionModel<EntityModel<Diploma>> getDiplomas();
	public abstract ResponseEntity<?> updateDiploma(Long id, Diploma nouveauDiploma);
	public abstract ResponseEntity<?> deleteDiploma(Long id);
}
