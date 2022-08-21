package ma.quantorion.appquitue.permissionrest.api;

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

import ma.quantorion.appquitue.permissionrest.domain.Permission;

@RestController
@RequestMapping("api/")
public class PermissionController
{
	
	@Autowired
	PermissionService permissionService;
	
	
	@GetMapping("Permissions")
	public CollectionModel<EntityModel<Permission>> getPermissions()
	{
		return permissionService.getPermissions();
	}
	
	@GetMapping("PersonTest")
	public String getPermission()
	{
		return "Reda Mazoz";
	}
	
	@GetMapping("Permissions/{id}")
	public EntityModel<Permission> getPermission(@PathVariable Long id)
	{
		return permissionService.getPermission(id);
	}
	
	@PostMapping("Permissions")
	public void addPermission(@RequestBody Permission permission)
	{
		permissionService.addPermission(permission);
		
	}
	
	@PutMapping("Permissions/{id}")
	public ResponseEntity<?> updatePermission(@PathVariable Long id, @RequestBody Permission nouveauPermission)
	{
		return permissionService.updatePermission(id, nouveauPermission);
	}
	
	@DeleteMapping("Permissions/{id}")
	public ResponseEntity<?> deletePermission(@PathVariable Long id)
	{
		return permissionService.deletePermission(id);
	}

}
