package ma.quantorion.appquitue.domain;

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

import ma.quantorion.appquitue.assembler.InjuryModelAssembler;
import ma.quantorion.appquitue.controller.InjuryController;
import ma.quantorion.appquitue.domain.interfaces.InjuryService;
import ma.quantorion.appquitue.exception.InjuryNotFoundException;
import ma.quantorion.appquitue.model.Injury;
import ma.quantorion.appquitue.repository.InjuryRepository;

@Service
public class InjuryServiceImpl implements InjuryService
{
	@Autowired
	public InjuryRepository injuryRepo;
	
	@Autowired
	public InjuryModelAssembler assembler;
	
	
	@Override
	public ResponseEntity<?> addInjury(Injury Injury)
	{
		EntityModel<Injury> entityModel = assembler
				.toModel(injuryRepo.save(Injury));
		return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
				.body(entityModel);
	}
	
	@Override
	public CollectionModel<EntityModel<Injury>> getInjurys()
	{
		
		List <EntityModel<Injury>> Injurys = injuryRepo.findAll().stream()
				.map(assembler::toModel)
				.collect(Collectors.toList());
		
		return CollectionModel.of(Injurys,
				linkTo(methodOn(InjuryController.class).getInjurys()).withSelfRel());
	}
	
	@Override
	public EntityModel<Injury> getInjury(Long id)
	{
		Injury p = injuryRepo.findById(id).orElseThrow(() -> new InjuryNotFoundException(id));
		return assembler.toModel(p);
	}
	
	@Override
	public ResponseEntity<?> updateInjury(Long id, Injury nouveauInjury)
	{
		Injury p = injuryRepo.findById(id)
				.map(injury -> {
					injury.setInjuryType(nouveauInjury.getInjuryType());
					injury.setInjuryDate(nouveauInjury.getInjuryDate());
					injury.setInjuryPlace(nouveauInjury.getInjuryPlace());
					return injuryRepo.save(injury);
				})
				.orElseGet(() -> {
					nouveauInjury.setInjuryId(id);
					return injuryRepo.save(nouveauInjury);
					});
		EntityModel<Injury> entityModel = assembler.toModel(p);
		
		return ResponseEntity
				.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
				.body(entityModel);	
	}
	
	@Override	
	public ResponseEntity<?> deleteInjury(Long id)
	{
		injuryRepo.deleteById(id);;
		return ResponseEntity.noContent().build();
	}
}
