package ma.quantorion.appquitue.diplomarest.api;

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

import ma.quantorion.appquitue.diplomarest.domain.Diploma;

@RestController
@RequestMapping("api/")
public class DiplomaController
{
	
	@Autowired
	DiplomaService diplomaService;
	
	
	@GetMapping("Diplomas")
	@PreAuthorize("hasAuthority('diploma:read')")
	public CollectionModel<EntityModel<Diploma>> getDiplomas()
	{
		return diplomaService.getDiplomas();
	}
	
	@GetMapping("Diplomas/{id}")
	@PreAuthorize("hasAuthority('diploma:read')")
	public EntityModel<Diploma> getDiploma(@PathVariable Long id)
	{
		return diplomaService.getDiploma(id);
	}
	
	@PostMapping("Diplomas")
	@PreAuthorize("hasAuthority('diploma:write')")
	public void addDiploma(@RequestBody Diploma diploma)
	{
		diplomaService.addDiploma(diploma);
		
	}
	
	@PutMapping("Diplomas/{id}")
	@PreAuthorize("hasAuthority('diploma:write')")
	public ResponseEntity<?> updateDiploma(@PathVariable Long id, @RequestBody Diploma nouveauDiploma)
	{
		return diplomaService.updateDiploma(id, nouveauDiploma);
	}
	
	@DeleteMapping("Diplomas/{id}")
	@PreAuthorize("hasAuthority('diploma:write')")
	public ResponseEntity<?> deleteDiploma(@PathVariable Long id)
	{
		return diplomaService.deleteDiploma(id);
	}

}
