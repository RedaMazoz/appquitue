package ma.quantorion.appquitue.controller;

import java.util.List;

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

import ma.quantorion.appquitue.domain.PersonnelService;
import ma.quantorion.appquitue.model.Personnel;

@RestController
@RequestMapping("api/")
public class PersonnelController
{
	
	@Autowired
	PersonnelService personnelService;
	
	
	
	@GetMapping("personnels")
	public CollectionModel<EntityModel<Personnel>> getPersonnels()
	{
		return personnelService.getPersonnels();
	}
	
	@GetMapping("personnels/{id}")
	public EntityModel<Personnel> getPersonnel(@PathVariable Long id)
	{
		return personnelService.getPersonnel(id);
	}
	
	@PostMapping("personnels")
	public void addPersonnel(@RequestBody Personnel personnel)
	{
		personnelService.addPersonnel(personnel);
		
	}
	
	@PutMapping("personnels/{id}")
	public ResponseEntity<?> updatePersonnel(@PathVariable Long id, @RequestBody Personnel nouveauPersonnel)
	{
		return personnelService.updatePersonnel(id, nouveauPersonnel);
	}
	
	@DeleteMapping("personnels/{id}")
	public ResponseEntity<?> deletePersonnel(@PathVariable Long id)
	{
		return personnelService.deletePersonnel(id);
	}

}
