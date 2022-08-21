package ma.quantorion.appquitue.missionrest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.quantorion.appquitue.missionrest.domain.Mission;

@RestController
@RequestMapping("api/")
public class MissionController
{
	
	@Autowired
	MissionService missionService;
	
	
	@GetMapping("Missions")
	public CollectionModel<EntityModel<Mission>> getMissions()
	{
		return missionService.getMissions();
	}
	
	@GetMapping("PersonTest")
	public String getMission()
	{
		return "Reda Mazoz";
	}
	
	@GetMapping("Missions/{id}")
	public EntityModel<Mission> getMission(@PathVariable Long id)
	{
		return missionService.getMission(id);
	}
	
	@PostMapping("Missions")
	public void addMission(@RequestBody Mission mission)
	{
		missionService.addMission(mission);
		
	}
	
	@PutMapping("Missions/{id}")
	public ResponseEntity<?> updateMission(@PathVariable Long id, @RequestBody Mission nouveauMission)
	{
		return missionService.updateMission(id, nouveauMission);
	}
	
	@DeleteMapping("Missions/{id}")
	public ResponseEntity<?> deleteMission(@PathVariable Long id)
	{
		return missionService.deleteMission(id);
	}

}
