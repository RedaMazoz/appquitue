package ma.quantorion.appquitue.injuryrest.api;

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

import ma.quantorion.appquitue.injuryrest.domain.Injury;

@RestController
@RequestMapping("api/")
public class InjuryController
{
	
	@Autowired
	InjuryService injuryService;
	
	
	@GetMapping("Injurys")
	public CollectionModel<EntityModel<Injury>> getInjurys()
	{
		return injuryService.getInjurys();
	}
	
	@GetMapping("PersonTest")
	public String getInjury()
	{
		return "Reda Mazoz";
	}
	
	@GetMapping("Injurys/{id}")
	public EntityModel<Injury> getInjury(@PathVariable Long id)
	{
		return injuryService.getInjury(id);
	}
	
	@PostMapping("Injurys")
	public void addInjury(@RequestBody Injury injury)
	{
		injuryService.addInjury(injury);
		
	}
	
	@PutMapping("Injurys/{id}")
	public ResponseEntity<?> updateInjury(@PathVariable Long id, @RequestBody Injury nouveauInjury)
	{
		return injuryService.updateInjury(id, nouveauInjury);
	}
	
	@DeleteMapping("Injurys/{id}")
	public ResponseEntity<?> deleteInjury(@PathVariable Long id)
	{
		return injuryService.deleteInjury(id);
	}

}
