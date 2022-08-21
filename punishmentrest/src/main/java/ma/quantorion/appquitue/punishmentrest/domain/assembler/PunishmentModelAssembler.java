package ma.quantorion.appquitue.punishmentrest.domain.assembler;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import ma.quantorion.appquitue.punishmentrest.api.PunishmentController;
import ma.quantorion.appquitue.punishmentrest.domain.Punishment;

@Component
public class PunishmentModelAssembler implements RepresentationModelAssembler<Punishment, EntityModel<Punishment>>
{
	@Override
	public EntityModel<Punishment> toModel(Punishment punishment)
	{
			
		return EntityModel.of(punishment,
				linkTo(methodOn(PunishmentController.class).getPunishment(punishment.getPunishmentId())).withSelfRel(),
				linkTo(methodOn(PunishmentController.class).getPunishments()).withRel("Punishments"));
	}

}
