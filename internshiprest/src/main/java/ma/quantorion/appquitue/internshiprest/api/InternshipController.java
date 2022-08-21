package ma.quantorion.appquitue.internshiprest.api;

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

import ma.quantorion.appquitue.internshiprest.domain.Internship;

@RestController
@RequestMapping("api/")
public class InternshipController
{
	
	@Autowired
	InternshipService internshipService;
	
	
	@GetMapping("Internships")
	public CollectionModel<EntityModel<Internship>> getInternships()
	{
		return internshipService.getInternships();
	}
	
	@GetMapping("PersonTest")
	public String getInternship()
	{
		return "Reda Mazoz";
	}
	
	@GetMapping("Internships/{id}")
	public EntityModel<Internship> getInternship(@PathVariable Long id)
	{
		return internshipService.getInternship(id);
	}
	
	@PostMapping("Internships")
	public void addInternship(@RequestBody Internship internship)
	{
		internshipService.addInternship(internship);
		
	}
	
	@PutMapping("Internships/{id}")
	public ResponseEntity<?> updateInternship(@PathVariable Long id, @RequestBody Internship nouveauInternship)
	{
		return internshipService.updateInternship(id, nouveauInternship);
	}
	
	@DeleteMapping("Internships/{id}")
	public ResponseEntity<?> deleteInternship(@PathVariable Long id)
	{
		return internshipService.deleteInternship(id);
	}

}
