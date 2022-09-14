package ma.quantorion.appquitue.apigateway.api;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

import ma.quantorion.appquitue.apigateway.domain.User;

public interface UserService
{
	public abstract ResponseEntity<?> addUser(User User);
	public abstract EntityModel<User> getUser(Long id);
	public abstract CollectionModel<EntityModel<User>> getUsers();
	public abstract ResponseEntity<?> updateUser(Long id, User nouveauUser);
	public abstract ResponseEntity<?> deleteUser(Long id);
	
}
