package ma.quantorion.appquitue.permissionrest.domain;

import java.util.List;
import java.util.Optional;

public interface PermissionRepository
{
	List<Permission> findAll();
	Optional<Permission> findById(Long id);
	Permission save(Permission permission);
	void deleteById(Long id);
}
