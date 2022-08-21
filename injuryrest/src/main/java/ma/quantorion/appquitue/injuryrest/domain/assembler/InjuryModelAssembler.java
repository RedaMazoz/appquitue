package ma.quantorion.appquitue.injuryrest.domain.assembler;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import ma.quantorion.appquitue.injuryrest.api.InjuryController;
import ma.quantorion.appquitue.injuryrest.domain.Injury;

@Component
public class InjuryModelAssembler implements RepresentationModelAssembler<Injury, EntityModel<Injury>>
{
	@Override
	public EntityModel<Injury> toModel(Injury injury)
	{
			
		return EntityModel.of(injury,
				linkTo(methodOn(InjuryController.class).getInjury(injury.getInjuryId())).withSelfRel(),
				linkTo(methodOn(InjuryController.class).getInjurys()).withRel("Injurys"));
	}

}
