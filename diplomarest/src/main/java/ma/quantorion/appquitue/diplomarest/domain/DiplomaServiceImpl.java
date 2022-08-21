package ma.quantorion.appquitue.diplomarest.domain;

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

import ma.quantorion.appquitue.diplomarest.api.DiplomaController;
import ma.quantorion.appquitue.diplomarest.api.DiplomaService;
import ma.quantorion.appquitue.diplomarest.domain.assembler.DiplomaModelAssembler;
import ma.quantorion.appquitue.diplomarest.domain.exception.DiplomaNotFoundException;

@Service
public class DiplomaServiceImpl implements DiplomaService
{
	@Autowired
	public DiplomaRepository diplomaRepo;
	
	@Autowired
	public DiplomaModelAssembler assembler;
	
	
	@Override
	public ResponseEntity<?> addDiploma(Diploma Diploma)
	{
		EntityModel<Diploma> entityModel = assembler
				.toModel(diplomaRepo.save(Diploma));
		return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
				.body(entityModel);
	}
	
	@Override
	public CollectionModel<EntityModel<Diploma>> getDiplomas()
	{
		
		List <EntityModel<Diploma>> Diplomas = diplomaRepo.findAll().stream()
				.map(assembler::toModel)
				.collect(Collectors.toList());
		
		return CollectionModel.of(Diplomas,
				linkTo(methodOn(DiplomaController.class).getDiplomas()).withSelfRel());
	}
	
	@Override
	public EntityModel<Diploma> getDiploma(Long id)
	{
		Diploma p = diplomaRepo.findById(id).orElseThrow(() -> new DiplomaNotFoundException(id));
		return assembler.toModel(p);
	}
	
	@Override
	public ResponseEntity<?> updateDiploma(Long id, Diploma nouveauDiploma)
	{
		Diploma p = diplomaRepo.findById(id)
				.map(diploma -> {
					diploma.setDiplomaType(nouveauDiploma.getDiplomaType());
					diploma.setDiplomaDesignation(nouveauDiploma.getDiplomaDesignation());
					diploma.setDiplomaDateObtained(nouveauDiploma.getDiplomaDateObtained());
					return diplomaRepo.save(diploma);
				})
				.orElseGet(() -> {
					nouveauDiploma.setDiplomaId(id);
					return diplomaRepo.save(nouveauDiploma);
					});
		EntityModel<Diploma> entityModel = assembler.toModel(p);
		
		return ResponseEntity
				.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
				.body(entityModel);	
	}
	
	@Override	
	public ResponseEntity<?> deleteDiploma(Long id)
	{
		diplomaRepo.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
