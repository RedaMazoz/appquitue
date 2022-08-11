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

import ma.quantorion.appquitue.assembler.PunishmentModelAssembler;
import ma.quantorion.appquitue.controller.PunishmentController;
import ma.quantorion.appquitue.domain.interfaces.PunishmentService;
import ma.quantorion.appquitue.exception.PunishmentNotFoundException;
import ma.quantorion.appquitue.model.Punishment;
import ma.quantorion.appquitue.repository.PunishmentRepository;

@Service
public class PunishmentServiceImpl implements PunishmentService
{
	@Autowired
	public PunishmentRepository condamnationRepo;
	
	@Autowired
	public PunishmentModelAssembler assembler;
	
	
	@Override
	public ResponseEntity<?> addPunishment(Punishment Punishment)
	{
		EntityModel<Punishment> entityModel = assembler
				.toModel(condamnationRepo.save(Punishment));
		return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
				.body(entityModel);
	}
	
	@Override
	public CollectionModel<EntityModel<Punishment>> getPunishments()
	{
		
		List <EntityModel<Punishment>> Punishments = condamnationRepo.findAll().stream()
				.map(assembler::toModel)
				.collect(Collectors.toList());
		
		return CollectionModel.of(Punishments,
				linkTo(methodOn(PunishmentController.class).getPunishments()).withSelfRel());
	}
	
	@Override
	public EntityModel<Punishment> getPunishment(Long id)
	{
		Punishment p = condamnationRepo.findById(id).orElseThrow(() -> new PunishmentNotFoundException(id));
		return assembler.toModel(p);
	}
	
	@Override
	public ResponseEntity<?> updatePunishment(Long id, Punishment nouveauPunishment)
	{
		Punishment p = condamnationRepo.findById(id)
				.map(condamnation -> {
					condamnation.setPunishmentDaysNumber(nouveauPunishment.getPunishmentDaysNumber());
					condamnation.setPunishmentMotive(nouveauPunishment.getPunishmentMotive());
					condamnation.setPunishmentDate(nouveauPunishment.getPunishmentDate());
					return condamnationRepo.save(condamnation);
				})
				.orElseGet(() -> {
					nouveauPunishment.setPunishmentId(id);
					return condamnationRepo.save(nouveauPunishment);
					});
		EntityModel<Punishment> entityModel = assembler.toModel(p);
		
		return ResponseEntity
				.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
				.body(entityModel);	
	}
	
	@Override	
	public ResponseEntity<?> deletePunishment(Long id)
	{
		condamnationRepo.deleteById(id);;
		return ResponseEntity.noContent().build();
	}
}
