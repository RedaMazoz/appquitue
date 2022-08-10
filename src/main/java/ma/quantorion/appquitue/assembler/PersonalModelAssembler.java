package ma.quantorion.appquitue.assembler;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import ma.quantorion.appquitue.controller.PersonalController;
import ma.quantorion.appquitue.model.Personal;

@Component
public class PersonalModelAssembler implements RepresentationModelAssembler<Personal, EntityModel<Personal>>
{
	@Override
	public EntityModel<Personal> toModel(Personal personal)
	{
			
		return EntityModel.of(personal,
				linkTo(methodOn(PersonalController.class).getPersonal(personal.getPersonalId())).withSelfRel(),
				linkTo(methodOn(PersonalController.class).getPersonals()).withRel("Personals"));
	}

}
