package ma.quantorion.appquitue.domain.interfaces;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

import ma.quantorion.appquitue.model.Permission;

public interface PermissionService
{
	public abstract ResponseEntity<?> addPermission(Permission Permission);
	public abstract EntityModel<Permission> getPermission(Long id);
	public abstract CollectionModel<EntityModel<Permission>> getPermissions();
	public abstract ResponseEntity<?> updatePermission(Long id, Permission nouveauPermission);
	public abstract ResponseEntity<?> deletePermission(Long id);
}
