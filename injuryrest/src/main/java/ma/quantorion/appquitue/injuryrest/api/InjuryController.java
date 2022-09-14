package ma.quantorion.appquitue.injuryrest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
	@PreAuthorize("hasAuthority('injury:read')")
	public CollectionModel<EntityModel<Injury>> getInjurys()
	{
		return injuryService.getInjurys();
	}
	
	@GetMapping("Injurys/{id}")
	@PreAuthorize("hasAuthority('injury:read')")
	public EntityModel<Injury> getInjury(@PathVariable Long id)
	{
		return injuryService.getInjury(id);
	}
	
	@PostMapping("Injurys")
	@PreAuthorize("hasAuthority('injury:write')")
	public void addInjury(@RequestBody Injury injury)
	{
		injuryService.addInjury(injury);
		
	}
	
	@PutMapping("Injurys/{id}")
	@PreAuthorize("hasAuthority('injury:write')")
	public ResponseEntity<?> updateInjury(@PathVariable Long id, @RequestBody Injury nouveauInjury)
	{
		return injuryService.updateInjury(id, nouveauInjury);
	}
	
	@DeleteMapping("Injurys/{id}")
	@PreAuthorize("hasAuthority('injury:write')")
	public ResponseEntity<?> deleteInjury(@PathVariable Long id)
	{
		return injuryService.deleteInjury(id);
	}

}
