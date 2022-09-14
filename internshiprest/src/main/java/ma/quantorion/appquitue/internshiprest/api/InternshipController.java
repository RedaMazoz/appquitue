package ma.quantorion.appquitue.internshiprest.api;

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

import ma.quantorion.appquitue.internshiprest.domain.Internship;

@RestController
@RequestMapping("api/")
public class InternshipController
{
	
	@Autowired
	InternshipService internshipService;
	
	
	@GetMapping("Internships")
	@PreAuthorize("hasAuthority('internship:read')")
	public CollectionModel<EntityModel<Internship>> getInternships()
	{
		return internshipService.getInternships();
	}
	
	@GetMapping("Internships/{id}")
	@PreAuthorize("hasAuthority('internship:read')")
	public EntityModel<Internship> getInternship(@PathVariable Long id)
	{
		return internshipService.getInternship(id);
	}
	
	@PostMapping("Internships")
	@PreAuthorize("hasAuthority('internship:write')")
	public void addInternship(@RequestBody Internship internship)
	{
		internshipService.addInternship(internship);
		
	}
	
	@PutMapping("Internships/{id}")
	@PreAuthorize("hasAuthority('internship:write')")
	public ResponseEntity<?> updateInternship(@PathVariable Long id, @RequestBody Internship nouveauInternship)
	{
		return internshipService.updateInternship(id, nouveauInternship);
	}
	
	@DeleteMapping("Internships/{id}")
	@PreAuthorize("hasAuthority('internship:write')")
	public ResponseEntity<?> deleteInternship(@PathVariable Long id)
	{
		return internshipService.deleteInternship(id);
	}

}
