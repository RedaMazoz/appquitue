package ma.quantorion.appquitue.assembler;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import ma.quantorion.appquitue.controller.CondamnationController;
import ma.quantorion.appquitue.model.Condamnation;

@Component
public class CondamnationModelAssembler implements RepresentationModelAssembler<Condamnation, EntityModel<Condamnation>>
{
	@Override
	public EntityModel<Condamnation> toModel(Condamnation condamnation)
	{
			
		return EntityModel.of(condamnation,
				linkTo(methodOn(CondamnationController.class).getCondamnation(condamnation.getCondamnationId())).withSelfRel(),
				linkTo(methodOn(CondamnationController.class).getCondamnations()).withRel("Condamnations"));
	}

}
