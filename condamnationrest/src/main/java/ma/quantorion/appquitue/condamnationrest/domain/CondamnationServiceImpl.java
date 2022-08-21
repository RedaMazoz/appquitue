package ma.quantorion.appquitue.condamnationrest.domain;

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

import ma.quantorion.appquitue.condamnationrest.api.CondamnationController;
import ma.quantorion.appquitue.condamnationrest.api.CondamnationService;
import ma.quantorion.appquitue.condamnationrest.domain.assembler.CondamnationModelAssembler;
import ma.quantorion.appquitue.condamnationrest.domain.exception.CondamnationNotFoundException;

@Service
public class CondamnationServiceImpl implements CondamnationService
{
	@Autowired
	public CondamnationRepository condamnationRepo;
	
	@Autowired
	public CondamnationModelAssembler assembler;
	
	
	@Override
	public ResponseEntity<?> addCondamnation(Condamnation Condamnation)
	{
		EntityModel<Condamnation> entityModel = assembler
				.toModel(condamnationRepo.save(Condamnation));
		return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
				.body(entityModel);
	}
	
	@Override
	public CollectionModel<EntityModel<Condamnation>> getCondamnations()
	{
		
		List <EntityModel<Condamnation>> Condamnations = condamnationRepo.findAll().stream()
				.map(assembler::toModel)
				.collect(Collectors.toList());
		
		return CollectionModel.of(Condamnations,
				linkTo(methodOn(CondamnationController.class).getCondamnations()).withSelfRel());
	}
	
	@Override
	public EntityModel<Condamnation> getCondamnation(Long id)
	{
		Condamnation p = condamnationRepo.findById(id).orElseThrow(() -> new CondamnationNotFoundException(id));
		return assembler.toModel(p);
	}
	
	@Override
	public ResponseEntity<?> updateCondamnation(Long id, Condamnation nouveauCondamnation)
	{
		Condamnation p = condamnationRepo.findById(id)
				.map(condamnation -> {
					condamnation.setCondamnationNature(nouveauCondamnation.getCondamnationNature());
					condamnation.setCondamnationPeriod(nouveauCondamnation.getCondamnationPeriod());
					condamnation.setCondamnationMotive(nouveauCondamnation.getCondamnationMotive());
					condamnation.setCondamnationDate(nouveauCondamnation.getCondamnationDate());
					condamnation.setCondamnationReference(nouveauCondamnation.getCondamnationReference());
					return condamnationRepo.save(condamnation);
				})
				.orElseGet(() -> {
					nouveauCondamnation.setCondamnationId(id);
					return condamnationRepo.save(nouveauCondamnation);
					});
		EntityModel<Condamnation> entityModel = assembler.toModel(p);
		
		return ResponseEntity
				.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
				.body(entityModel);	
	}
	
	@Override	
	public ResponseEntity<?> deleteCondamnation(Long id)
	{
		condamnationRepo.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
