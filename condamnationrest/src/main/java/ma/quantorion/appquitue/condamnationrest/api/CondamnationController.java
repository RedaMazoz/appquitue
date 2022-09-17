package ma.quantorion.appquitue.condamnationrest.api;

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

import ma.quantorion.appquitue.condamnationrest.domain.Condamnation;
import ma.quantorion.appquitue.condamnationrest.domain.CondamnationService;

@RestController
@RequestMapping("api/")
public class CondamnationController
{
	
	@Autowired
	CondamnationService condamnationService;
	
	
	@GetMapping("Condamnations")
	@PreAuthorize("hasAuthority('condamnation:read')")
	public CollectionModel<EntityModel<Condamnation>> getCondamnations()
	{
		return condamnationService.getCondamnations();
	}
	
	@GetMapping("Condamnations/{id}")
	@PreAuthorize("hasAuthority('condamnation:read')")
	public EntityModel<Condamnation> getCondamnation(@PathVariable Long id)
	{
		return condamnationService.getCondamnation(id);
	}
	
	@PostMapping("Condamnations")
	@PreAuthorize("hasAuthority('condamnation:write')")
	public void addCondamnation(@RequestBody Condamnation condamnation)
	{
		condamnationService.addCondamnation(condamnation);
		
	}
	
	@PutMapping("Condamnations/{id}")
	@PreAuthorize("hasAuthority('condamnation:write')")
	public ResponseEntity<?> updateCondamnation(@PathVariable Long id, @RequestBody Condamnation nouveauCondamnation)
	{
		return condamnationService.updateCondamnation(id, nouveauCondamnation);
	}
	
	@DeleteMapping("Condamnations/{id}")
	@PreAuthorize("hasAuthority('condamnation:write')")
	public ResponseEntity<?> deleteCondamnation(@PathVariable Long id)
	{
		return condamnationService.deleteCondamnation(id);
	}

}
