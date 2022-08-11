package ma.quantorion.appquitue.domain.interfaces;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

import ma.quantorion.appquitue.model.Internship;

public interface InternshipService
{
	public abstract ResponseEntity<?> addInternship(Internship Internship);
	public abstract EntityModel<Internship> getInternship(Long id);
	public abstract CollectionModel<EntityModel<Internship>> getInternships();
	public abstract ResponseEntity<?> updateInternship(Long id, Internship nouveauInternship);
	public abstract ResponseEntity<?> deleteInternship(Long id);
}
