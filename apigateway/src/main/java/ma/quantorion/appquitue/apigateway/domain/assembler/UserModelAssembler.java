package ma.quantorion.appquitue.apigateway.domain.assembler;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import ma.quantorion.appquitue.apigateway.api.UserController;
import ma.quantorion.appquitue.apigateway.domain.User;

@Component
public class UserModelAssembler implements RepresentationModelAssembler<User, EntityModel<User>>
{
	@Override
	public EntityModel<User> toModel(User user)
	{
			
		return EntityModel.of(user,
				linkTo(methodOn(UserController.class).getUser(user.getUserId())).withSelfRel(),
				linkTo(methodOn(UserController.class).getUsers()).withRel("Users"));
	}

}
