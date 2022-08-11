package ma.quantorion.appquitue.assembler;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import ma.quantorion.appquitue.controller.PermissionController;
import ma.quantorion.appquitue.model.Permission;

@Component
public class PermissionModelAssembler implements RepresentationModelAssembler<Permission, EntityModel<Permission>>
{
	@Override
	public EntityModel<Permission> toModel(Permission permission)
	{
			
		return EntityModel.of(permission,
				linkTo(methodOn(PermissionController.class).getPermission(permission.getPermissionId())).withSelfRel(),
				linkTo(methodOn(PermissionController.class).getPermissions()).withRel("Permissions"));
	}

}
