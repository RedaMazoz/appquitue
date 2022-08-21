package ma.quantorion.appquitue.punishmentrest.domain;

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

import ma.quantorion.appquitue.punishmentrest.api.PunishmentController;
import ma.quantorion.appquitue.punishmentrest.api.PunishmentService;
import ma.quantorion.appquitue.punishmentrest.domain.assembler.PunishmentModelAssembler;
import ma.quantorion.appquitue.punishmentrest.domain.exception.PunishmentNotFoundException;

@Service
public class PunishmentServiceImpl implements PunishmentService
{
	@Autowired
	public PunishmentRepository punishmentRepo;
	
	@Autowired
	public PunishmentModelAssembler assembler;
	
	
	@Override
	public ResponseEntity<?> addPunishment(Punishment Punishment)
	{
		EntityModel<Punishment> entityModel = assembler
				.toModel(punishmentRepo.save(Punishment));
		return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
				.body(entityModel);
	}
	
	@Override
	public CollectionModel<EntityModel<Punishment>> getPunishments()
	{
		
		List <EntityModel<Punishment>> Punishments = punishmentRepo.findAll().stream()
				.map(assembler::toModel)
				.collect(Collectors.toList());
		
		return CollectionModel.of(Punishments,
				linkTo(methodOn(PunishmentController.class).getPunishments()).withSelfRel());
	}
	
	@Override
	public EntityModel<Punishment> getPunishment(Long id)
	{
		Punishment p = punishmentRepo.findById(id).orElseThrow(() -> new PunishmentNotFoundException(id));
		return assembler.toModel(p);
	}
	
	@Override
	public ResponseEntity<?> updatePunishment(Long id, Punishment nouveauPunishment)
	{
		Punishment p = punishmentRepo.findById(id)
				.map(punishment -> {
					punishment.setPunishmentDaysNumber(nouveauPunishment.getPunishmentDaysNumber());
					punishment.setPunishmentMotive(nouveauPunishment.getPunishmentMotive());
					punishment.setPunishmentDate(nouveauPunishment.getPunishmentDate());
					return punishmentRepo.save(punishment);
				})
				.orElseGet(() -> {
					nouveauPunishment.setPunishmentId(id);
					return punishmentRepo.save(nouveauPunishment);
					});
		EntityModel<Punishment> entityModel = assembler.toModel(p);
		
		return ResponseEntity
				.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
				.body(entityModel);	
	}
	
	@Override	
	public ResponseEntity<?> deletePunishment(Long id)
	{
		punishmentRepo.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
