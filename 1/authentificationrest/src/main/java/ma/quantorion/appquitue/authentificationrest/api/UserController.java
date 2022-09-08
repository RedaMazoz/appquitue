package ma.quantorion.appquitue.authentificationrest.api;

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

import ma.quantorion.appquitue.authentificationrest.domain.User;

@RestController
public class UserController
{
	
	@Autowired
	UserService userService;
	
	
	@GetMapping("Users")
	@PreAuthorize("hasAuthority('punishment:read')")
	public CollectionModel<EntityModel<User>> getUsers()
	{
		System.out.println("d");
		return userService.getUsers();
	}
	
	@GetMapping("Users/{id}")
	@PreAuthorize("hasAuthority('punishment:read')")
	public EntityModel<User> getUser(@PathVariable Long id)
	{
		return userService.getUser(id);
	}
	
	@PostMapping("Users")
	@PreAuthorize("hasAuthority('punishment:write')")
	public void addUser(@RequestBody User user)
	{
		userService.addUser(user);
		
	}
	
	@PutMapping("Users/{id}")
	@PreAuthorize("hasAuthority('punishment:write')")
	public ResponseEntity<?> updateCondamnation(@PathVariable Long id, @RequestBody User nouveauCondamnation)
	{
		return userService.updateUser(id, nouveauCondamnation);
	}
	
	@DeleteMapping("Users/{id}")
	@PreAuthorize("hasAuthority('punishment:write')")
	public ResponseEntity<?> deleteCondamnation(@PathVariable Long id)
	{
		return userService.deleteUser(id);
	}

}
