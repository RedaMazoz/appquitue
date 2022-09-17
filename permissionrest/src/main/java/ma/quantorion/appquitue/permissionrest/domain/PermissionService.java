package ma.quantorion.appquitue.permissionrest.domain;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

public interface PermissionService
{
	public abstract ResponseEntity<?> addPermission(Permission Permission);
	public abstract EntityModel<Permission> getPermission(Long id);
	public abstract CollectionModel<EntityModel<Permission>> getPermissions();
	public abstract ResponseEntity<?> updatePermission(Long id, Permission nouveauPermission);
	public abstract ResponseEntity<?> deletePermission(Long id);
	
}
