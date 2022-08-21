package ma.quantorion.appquitue.missionrest.api;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

import ma.quantorion.appquitue.missionrest.domain.Mission;

public interface MissionService
{
	public abstract ResponseEntity<?> addMission(Mission Mission);
	public abstract EntityModel<Mission> getMission(Long id);
	public abstract CollectionModel<EntityModel<Mission>> getMissions();
	public abstract ResponseEntity<?> updateMission(Long id, Mission nouveauMission);
	public abstract ResponseEntity<?> deleteMission(Long id);
	
}
