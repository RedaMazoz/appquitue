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

import ma.quantorion.appquitue.assembler.PermissionModelAssembler;
import ma.quantorion.appquitue.controller.PermissionController;
import ma.quantorion.appquitue.domain.interfaces.PermissionService;
import ma.quantorion.appquitue.exception.PermissionNotFoundException;
import ma.quantorion.appquitue.model.Permission;
import ma.quantorion.appquitue.repository.PermissionRepository;

@Service
public class PermissionServiceImpl implements PermissionService
{
	@Autowired
	public PermissionRepository permissionRepo;
	
	@Autowired
	public PermissionModelAssembler assembler;
	
	
	@Override
	public ResponseEntity<?> addPermission(Permission Permission)
	{
		EntityModel<Permission> entityModel = assembler
				.toModel(permissionRepo.save(Permission));
		return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
				.body(entityModel);
	}
	
	@Override
	public CollectionModel<EntityModel<Permission>> getPermissions()
	{
		
		List <EntityModel<Permission>> Permissions = permissionRepo.findAll().stream()
				.map(assembler::toModel)
				.collect(Collectors.toList());
		
		return CollectionModel.of(Permissions,
				linkTo(methodOn(PermissionController.class).getPermissions()).withSelfRel());
	}
	
	@Override
	public EntityModel<Permission> getPermission(Long id)
	{
		Permission p = permissionRepo.findById(id).orElseThrow(() -> new PermissionNotFoundException(id));
		return assembler.toModel(p);
	}
	
	@Override
	public ResponseEntity<?> updatePermission(Long id, Permission nouveauPermission)
	{
		Permission p = permissionRepo.findById(id)
				.map(permission -> {
					permission.setPermissionType(nouveauPermission.getPermissionType());
					permission.setPermissionStartDate(nouveauPermission.getPermissionStartDate());
					permission.setPermissionEndDate(nouveauPermission.getPermissionEndDate());
					permission.setPermissionObservation(nouveauPermission.getPermissionObservation());
					permission.setPermissionDestination(nouveauPermission.getPermissionDestination());
					return permissionRepo.save(permission);
				})
				.orElseGet(() -> {
					nouveauPermission.setPermissionId(id);
					return permissionRepo.save(nouveauPermission);
					});
		EntityModel<Permission> entityModel = assembler.toModel(p);
		
		return ResponseEntity
				.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
				.body(entityModel);	
	}
	
	@Override	
	public ResponseEntity<?> deletePermission(Long id)
	{
		permissionRepo.deleteById(id);;
		return ResponseEntity.noContent().build();
	}
}
