package ma.quantorion.appquitue.condamnationrest.api;

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

import ma.quantorion.appquitue.condamnationrest.domain.Condamnation;

@RestController
@RequestMapping("api/")
public class CondamnationController
{
	
	@Autowired
	CondamnationService condamnationService;
	
	
	@GetMapping("Condamnations")
	public CollectionModel<EntityModel<Condamnation>> getCondamnations()
	{
		return condamnationService.getCondamnations();
	}
	
	@GetMapping("PersonTest")
	public String getCondamnation()
	{
		return "Reda Mazoz";
	}
	
	@GetMapping("Condamnations/{id}")
	public EntityModel<Condamnation> getCondamnation(@PathVariable Long id)
	{
		return condamnationService.getCondamnation(id);
	}
	
	@PostMapping("Condamnations")
	public void addCondamnation(@RequestBody Condamnation condamnation)
	{
		condamnationService.addCondamnation(condamnation);
		
	}
	
	@PutMapping("Condamnations/{id}")
	public ResponseEntity<?> updateCondamnation(@PathVariable Long id, @RequestBody Condamnation nouveauCondamnation)
	{
		return condamnationService.updateCondamnation(id, nouveauCondamnation);
	}
	
	@DeleteMapping("Condamnations/{id}")
	public ResponseEntity<?> deleteCondamnation(@PathVariable Long id)
	{
		return condamnationService.deleteCondamnation(id);
	}

}
