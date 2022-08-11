package ma.quantorion.appquitue.assembler;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import ma.quantorion.appquitue.controller.DiplomaController;
import ma.quantorion.appquitue.model.Diploma;

@Component
public class DiplomaModelAssembler implements RepresentationModelAssembler<Diploma, EntityModel<Diploma>>
{
	@Override
	public EntityModel<Diploma> toModel(Diploma diploma)
	{
			
		return EntityModel.of(diploma,
				linkTo(methodOn(DiplomaController.class).getDiploma(diploma.getDiplomaId())).withSelfRel(),
				linkTo(methodOn(DiplomaController.class).getDiplomas()).withRel("Diplomas"));
	}

}
