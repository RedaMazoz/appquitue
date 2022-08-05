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

import ma.quantorion.appquitue.assembler.PersonnelModelAssembler;
import ma.quantorion.appquitue.controller.PersonnelController;
import ma.quantorion.appquitue.exception.PersonnelNotFoundException;
import ma.quantorion.appquitue.model.Personnel;
import ma.quantorion.appquitue.repository.PersonnelRepository;

@Service
public class PersonnelServiceImpl implements PersonnelService
{
	@Autowired
	public PersonnelRepository personnelRepo;
	
	@Autowired
	public PersonnelModelAssembler assembler;
	
	
	@Override
	public ResponseEntity<?> addPersonnel(Personnel personnel)
	{
		EntityModel<Personnel> entityModel = assembler
				.toModel(personnelRepo.save(personnel));
		return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
				.body(entityModel);
	}
	
	@Override
	public CollectionModel<EntityModel<Personnel>> getPersonnels()
	{
		
		List <EntityModel<Personnel>> personnels = personnelRepo.findAll().stream()
				.map(assembler::toModel)
				.collect(Collectors.toList());
		
		return CollectionModel.of(personnels,
				linkTo(methodOn(PersonnelController.class).getPersonnels()).withSelfRel());
	}
	
	@Override
	public String getPersonnelBasic(Long id)
	{
		Personnel p = personnelRepo.findById(id).orElseThrow(() -> new PersonnelNotFoundException(id));
		return p.getFirstName() + " " + p.getLastName();
	}
	
	@Override
	public EntityModel<Personnel> getPersonnel(Long id)
	{
		Personnel p = personnelRepo.findById(id).orElseThrow(() -> new PersonnelNotFoundException(id));
		return assembler.toModel(p);
	}
	
	@Override
	public ResponseEntity<?> updatePersonnel(Long id, Personnel nouveauPersonnel)
	{
		Personnel p = personnelRepo.findById(id)
				.map(personnel -> {
					personnel.setFirstName(nouveauPersonnel.getFirstName());
					personnel.setLastName(nouveauPersonnel.getLastName());
					return personnelRepo.save(personnel);
				})
				.orElseGet(() -> {
					nouveauPersonnel.setPersonnelId(id);
					return personnelRepo.save(nouveauPersonnel);
					});
		EntityModel<Personnel> entityModel = assembler.toModel(p);
		
		return ResponseEntity
				.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
				.body(entityModel);	
	}
	
	@Override	
	public ResponseEntity<?> deletePersonnel(Long id)
	{
		personnelRepo.deleteById(id);;
		return ResponseEntity.noContent().build();
	}
}
