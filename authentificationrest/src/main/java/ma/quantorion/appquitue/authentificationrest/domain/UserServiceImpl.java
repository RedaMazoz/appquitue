package ma.quantorion.appquitue.authentificationrest.domain;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ma.quantorion.appquitue.authentificationrest.api.UserController;
import ma.quantorion.appquitue.authentificationrest.api.UserService;
import ma.quantorion.appquitue.authentificationrest.domain.assembler.UserModelAssembler;
import ma.quantorion.appquitue.authentificationrest.domain.exception.UserNotFoundException;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	public UserRepository userRepo;
	
	@Autowired
	public UserModelAssembler assembler;
	
	
	@Override
	public ResponseEntity<?> addUser(User User)
	{
		EntityModel<User> entityModel = assembler
				.toModel(userRepo.save(User));
		return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
				.body(entityModel);
	}
	
	@Override
	public CollectionModel<EntityModel<User>> getUsers()
	{
		
		List <EntityModel<User>> Users = userRepo.findAll().stream()
				.map(assembler::toModel)
				.collect(Collectors.toList());
		
		return CollectionModel.of(Users,
				linkTo(methodOn(UserController.class).getUsers()).withSelfRel());
	}
	
	@Override
	public EntityModel<User> getUser(Long id)
	{
		User p = userRepo.findById(id).orElseThrow(() -> new UserNotFoundException(id));
		return assembler.toModel(p);
	}
	
	@Override
	public ResponseEntity<?> updateUser(Long id, User nouveauUser)
	{
		User p = userRepo.findById(id)
				.map(user -> {
					user.setEmail(nouveauUser.getEmail());
					user.setPassword(nouveauUser.getPassword());
					return userRepo.save(user);
				})
				.orElseGet(() -> {
					nouveauUser.setUserId(id);
					return userRepo.save(nouveauUser);
					});
		EntityModel<User> entityModel = assembler.toModel(p);
		
		return ResponseEntity
				.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
				.body(entityModel);	
	}
	
	@Override	
	public ResponseEntity<?> deleteUser(Long id)
	{
		userRepo.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
