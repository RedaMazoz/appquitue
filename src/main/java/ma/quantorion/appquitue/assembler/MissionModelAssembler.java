package ma.quantorion.appquitue.assembler;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import ma.quantorion.appquitue.controller.MissionController;
import ma.quantorion.appquitue.model.Mission;

@Component
public class MissionModelAssembler implements RepresentationModelAssembler<Mission, EntityModel<Mission>>
{
	@Override
	public EntityModel<Mission> toModel(Mission mission)
	{
			
		return EntityModel.of(mission,
				linkTo(methodOn(MissionController.class).getMission(mission.getMissionId())).withSelfRel(),
				linkTo(methodOn(MissionController.class).getMissions()).withRel("Missions"));
	}

}
