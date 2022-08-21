package ma.quantorion.appquitue.internshiprest.domain;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ma.quantorion.appquitue.internshiprest.api.InternshipController;
import ma.quantorion.appquitue.internshiprest.api.InternshipService;
import ma.quantorion.appquitue.internshiprest.domain.assembler.InternshipModelAssembler;
import ma.quantorion.appquitue.internshiprest.domain.exception.InternshipNotFoundException;

@Service
public class InternshipServiceImpl implements InternshipService
{
	@Autowired
	public InternshipRepository internshipRepo;
	
	@Autowired
	public InternshipModelAssembler assembler;
	
	
	@Override
	public ResponseEntity<?> addInternship(Internship Internship)
	{
		EntityModel<Internship> entityModel = assembler
				.toModel(internshipRepo.save(Internship));
		return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
				.body(entityModel);
	}
	
	@Override
	public CollectionModel<EntityModel<Internship>> getInternships()
	{
		
		List <EntityModel<Internship>> Internships = internshipRepo.findAll().stream()
				.map(assembler::toModel)
				.collect(Collectors.toList());
		
		return CollectionModel.of(Internships,
				linkTo(methodOn(InternshipController.class).getInternships()).withSelfRel());
	}
	
	@Override
	public EntityModel<Internship> getInternship(Long id)
	{
		Internship p = internshipRepo.findById(id).orElseThrow(() -> new InternshipNotFoundException(id));
		return assembler.toModel(p);
	}
	
	@Override
	public ResponseEntity<?> updateInternship(Long id, Internship nouveauInternship)
	{
		Internship p = internshipRepo.findById(id)
				.map(internship -> {
					internship.setInternshipDesignation(nouveauInternship.getInternshipDesignation());
					internship.setInternshipStartDate(nouveauInternship.getInternshipStartDate());
					internship.setInternshipEndDate(nouveauInternship.getInternshipEndDate());
					return internshipRepo.save(internship);
				})
				.orElseGet(() -> {
					nouveauInternship.setInternshipId(id);
					return internshipRepo.save(nouveauInternship);
					});
		EntityModel<Internship> entityModel = assembler.toModel(p);
		
		return ResponseEntity
				.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
				.body(entityModel);	
	}
	
	@Override	
	public ResponseEntity<?> deleteInternship(Long id)
	{
		internshipRepo.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
