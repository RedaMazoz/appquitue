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

import ma.quantorion.appquitue.domain.interfaces.CondamnationService;
import ma.quantorion.appquitue.model.Condamnation;

@RestController
@RequestMapping("api/")
public class CondamnationController
{
	
	@Autowired
	CondamnationService condamnationService;
	
	
	@GetMapping("condamnations")
	public CollectionModel<EntityModel<Condamnation>> getCondamnations()
	{
		return condamnationService.getCondamnations();
	}
	
	@GetMapping("condamnations/{id}")
	public EntityModel<Condamnation> getCondamnation(@PathVariable Long id)
	{
		return condamnationService.getCondamnation(id);
	}
	
	@PostMapping("condamnations")
	public void addcondamnation(@RequestBody Condamnation condamnation)
	{
		condamnationService.addCondamnation(condamnation);
		
	}
	
	@PutMapping("condamnations/{id}")
	public ResponseEntity<?> updatecondamnation(@PathVariable Long id, @RequestBody Condamnation nouveaucondamnation)
	{
		return condamnationService.updateCondamnation(id, nouveaucondamnation);
	}
	
	@DeleteMapping("condamnations/{id}")
	public ResponseEntity<?> deletecondamnation(@PathVariable Long id)
	{
		return condamnationService.deleteCondamnation(id);
	}

}
