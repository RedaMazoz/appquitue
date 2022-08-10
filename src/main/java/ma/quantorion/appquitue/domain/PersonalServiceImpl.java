package ma.quantorion.appquitue.domain;

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

import ma.quantorion.appquitue.assembler.PersonalModelAssembler;
import ma.quantorion.appquitue.controller.PersonalController;
import ma.quantorion.appquitue.exception.PersonalNotFoundException;
import ma.quantorion.appquitue.model.Personal;
import ma.quantorion.appquitue.repository.PersonalRepository;

@Service
public class PersonalServiceImpl implements PersonalService
{
	@Autowired
	public PersonalRepository PersonalRepo;
	
	@Autowired
	public PersonalModelAssembler assembler;
	
	
	@Override
	public ResponseEntity<?> addPersonal(Personal Personal)
	{
		EntityModel<Personal> entityModel = assembler
				.toModel(PersonalRepo.save(Personal));
		return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
				.body(entityModel);
	}
	
	@Override
	public CollectionModel<EntityModel<Personal>> getPersonals()
	{
		
		List <EntityModel<Personal>> Personals = PersonalRepo.findAll().stream()
				.map(assembler::toModel)
				.collect(Collectors.toList());
		
		return CollectionModel.of(Personals,
				linkTo(methodOn(PersonalController.class).getPersonals()).withSelfRel());
	}
	
	@Override
	public String getPersonalBasic(Long id)
	{
		Personal p = PersonalRepo.findById(id).orElseThrow(() -> new PersonalNotFoundException(id));
		return p.getFirstName() + " " + p.getLastName();
	}
	
	@Override
	public EntityModel<Personal> getPersonal(Long id)
	{
		Personal p = PersonalRepo.findById(id).orElseThrow(() -> new PersonalNotFoundException(id));
		return assembler.toModel(p);
	}
	
	@Override
	public ResponseEntity<?> updatePersonal(Long id, Personal nouveauPersonal)
	{
		Personal p = PersonalRepo.findById(id)
				.map(personal -> {
					personal.setFirstName(nouveauPersonal.getFirstName());
					personal.setAddress(nouveauPersonal.getAddress());
					personal.setAddressPersonWhenAccident(nouveauPersonal.getAddressPersonWhenAccident());
					personal.setAffectationDate(nouveauPersonal.getAffectationDate());
					personal.setAffectationId(nouveauPersonal.getAffectationId());
					personal.setAffectationReference(nouveauPersonal.getAffectationReference());
					personal.setBirthdate(nouveauPersonal.getBirthdate());
					personal.setBirthplace(nouveauPersonal.getBirthplace());
					personal.setBloodType(nouveauPersonal.getBloodType());
					personal.setCcpId(nouveauPersonal.getCcpId());
					personal.setChildsCount(nouveauPersonal.getChildsCount());
					personal.setCity(nouveauPersonal.getCity());
					personal.setContactPersonWhenAccident(nouveauPersonal.getContactPersonWhenAccident());
					personal.setCurrentFunction(nouveauPersonal.getCurrentFunction());
					personal.setDadFullname(nouveauPersonal.getDadFullname());
					personal.setDadJob(nouveauPersonal.getDadJob());
					personal.setEngagementDate(nouveauPersonal.getEngagementDate());
					personal.setFamilySituation(nouveauPersonal.getFamilySituation());
					personal.setGovId(nouveauPersonal.getGovId());
					personal.setGrade(nouveauPersonal.getGrade());
					personal.setGsmNumber(nouveauPersonal.getGsmNumber());
					personal.setGsmNumberPersonWhenAccident(nouveauPersonal.getGsmNumberPersonWhenAccident());
					personal.setLastName(nouveauPersonal.getLastName());
					personal.setMatricule(nouveauPersonal.getMatricule());
					personal.setMumFullname(nouveauPersonal.getMumFullname());
					personal.setMumJob(nouveauPersonal.getMumJob());
					personal.setPhoto(nouveauPersonal.getPhoto());
					personal.setProvince(nouveauPersonal.getProvince());
					personal.setSomId(nouveauPersonal.getSomId());
					personal.setUnit(nouveauPersonal.getUnit());
					personal.setWifeAddress(nouveauPersonal.getWifeAddress());
					personal.setWifeFullname(nouveauPersonal.getWifeFullname());
					personal.setWifeJob(nouveauPersonal.getWifeJob());//34
					return PersonalRepo.save(personal);
				})
				.orElseGet(() -> {
					nouveauPersonal.setPersonalId(id);
					return PersonalRepo.save(nouveauPersonal);
					});
		EntityModel<Personal> entityModel = assembler.toModel(p);
		
		return ResponseEntity
				.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
				.body(entityModel);	
	}
	
	@Override	
	public ResponseEntity<?> deletePersonal(Long id)
	{
		PersonalRepo.deleteById(id);;
		return ResponseEntity.noContent().build();
	}
}
