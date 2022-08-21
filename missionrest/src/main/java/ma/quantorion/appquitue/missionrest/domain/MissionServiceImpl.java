package ma.quantorion.appquitue.missionrest.domain;

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

import ma.quantorion.appquitue.missionrest.api.MissionController;
import ma.quantorion.appquitue.missionrest.api.MissionService;
import ma.quantorion.appquitue.missionrest.domain.assembler.MissionModelAssembler;
import ma.quantorion.appquitue.missionrest.domain.exception.MissionNotFoundException;

@Service
public class MissionServiceImpl implements MissionService
{
	@Autowired
	public MissionRepository missionRepo;
	
	@Autowired
	public MissionModelAssembler assembler;
	
	
	@Override
	public ResponseEntity<?> addMission(Mission Mission)
	{
		EntityModel<Mission> entityModel = assembler
				.toModel(missionRepo.save(Mission));
		return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
				.body(entityModel);
	}
	
	@Override
	public CollectionModel<EntityModel<Mission>> getMissions()
	{
		
		List <EntityModel<Mission>> Missions = missionRepo.findAll().stream()
				.map(assembler::toModel)
				.collect(Collectors.toList());
		
		return CollectionModel.of(Missions,
				linkTo(methodOn(MissionController.class).getMissions()).withSelfRel());
	}
	
	@Override
	public EntityModel<Mission> getMission(Long id)
	{
		Mission p = missionRepo.findById(id).orElseThrow(() -> new MissionNotFoundException(id));
		return assembler.toModel(p);
	}
	
	@Override
	public ResponseEntity<?> updateMission(Long id, Mission nouveauMission)
	{
		Mission p = missionRepo.findById(id)
				.map(mission -> {
					mission.setMissionDesignation(nouveauMission.getMissionDesignation());
					mission.setMissionStartDate(nouveauMission.getMissionStartDate());
					mission.setMissionEndDate(nouveauMission.getMissionEndDate());
					return missionRepo.save(mission);
				})
				.orElseGet(() -> {
					nouveauMission.setMissionId(id);
					return missionRepo.save(nouveauMission);
					});
		EntityModel<Mission> entityModel = assembler.toModel(p);
		
		return ResponseEntity
				.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
				.body(entityModel);	
	}
	
	@Override	
	public ResponseEntity<?> deleteMission(Long id)
	{
		missionRepo.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
