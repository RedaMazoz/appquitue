package ma.quantorion.appquitue.assembler;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import ma.quantorion.appquitue.controller.PersonnelController;
import ma.quantorion.appquitue.model.Personnel;

@Component
public class PersonnelModelAssembler implements RepresentationModelAssembler<Personnel, EntityModel<Personnel>>
{
	@Override
	public EntityModel<Personnel> toModel(Personnel personnel)
	{
			
		return EntityModel.of(personnel,
				linkTo(methodOn(PersonnelController.class).getPersonnel(personnel.getPersonnelId())).withSelfRel(),
				linkTo(methodOn(PersonnelController.class).getPersonnels()).withRel("personnels"));
	}

}
