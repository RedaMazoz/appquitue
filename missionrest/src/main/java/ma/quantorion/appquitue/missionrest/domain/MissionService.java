package ma.quantorion.appquitue.missionrest.domain;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

public interface MissionService
{
	public abstract ResponseEntity<?> addMission(Mission Mission);
	public abstract EntityModel<Mission> getMission(Long id);
	public abstract CollectionModel<EntityModel<Mission>> getMissions();
	public abstract ResponseEntity<?> updateMission(Long id, Mission nouveauMission);
	public abstract ResponseEntity<?> deleteMission(Long id);
	
}
