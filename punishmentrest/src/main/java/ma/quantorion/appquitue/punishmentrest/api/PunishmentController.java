package ma.quantorion.appquitue.punishmentrest.api;

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

import ma.quantorion.appquitue.punishmentrest.domain.Punishment;

@RestController
@RequestMapping("api/")
public class PunishmentController
{
	
	@Autowired
	PunishmentService punishmentService;
	
	
	@GetMapping("Punishments")
	public CollectionModel<EntityModel<Punishment>> getPunishments()
	{
		return punishmentService.getPunishments();
	}
	
	@GetMapping("PersonTest")
	public String getPunishment()
	{
		return "Reda Mazoz";
	}
	
	@GetMapping("Punishments/{id}")
	public EntityModel<Punishment> getPunishment(@PathVariable Long id)
	{
		return punishmentService.getPunishment(id);
	}
	
	@PostMapping("Punishments")
	public void addPunishment(@RequestBody Punishment punishment)
	{
		punishmentService.addPunishment(punishment);
		
	}
	
	@PutMapping("Punishments/{id}")
	public ResponseEntity<?> updatePunishment(@PathVariable Long id, @RequestBody Punishment nouveauPunishment)
	{
		return punishmentService.updatePunishment(id, nouveauPunishment);
	}
	
	@DeleteMapping("Punishments/{id}")
	public ResponseEntity<?> deletePunishment(@PathVariable Long id)
	{
		return punishmentService.deletePunishment(id);
	}

}
