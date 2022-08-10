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

import ma.quantorion.appquitue.domain.PersonalService;
import ma.quantorion.appquitue.model.Personal;

@RestController
@RequestMapping("api/")
public class PersonalController
{
	
	@Autowired
	PersonalService PersonalService;
	
	
	
	@GetMapping("Personals")
	public CollectionModel<EntityModel<Personal>> getPersonals()
	{
		return PersonalService.getPersonals();
	}
	
	@GetMapping("Personals/{id}")
	public EntityModel<Personal> getPersonal(@PathVariable Long id)
	{
		return PersonalService.getPersonal(id);
	}
	
	@PostMapping("Personals")
	public void addPersonal(@RequestBody Personal Personal)
	{
		PersonalService.addPersonal(Personal);
		
	}
	
	@PutMapping("Personals/{id}")
	public ResponseEntity<?> updatePersonal(@PathVariable Long id, @RequestBody Personal nouveauPersonal)
	{
		return PersonalService.updatePersonal(id, nouveauPersonal);
	}
	
	@DeleteMapping("Personals/{id}")
	public ResponseEntity<?> deletePersonal(@PathVariable Long id)
	{
		return PersonalService.deletePersonal(id);
	}

}
