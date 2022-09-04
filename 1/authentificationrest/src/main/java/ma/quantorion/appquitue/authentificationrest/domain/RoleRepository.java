package ma.quantorion.appquitue.authentificationrest.domain;

import java.util.List;
import java.util.Optional;

public interface RoleRepository
{
	List<Role> findAll();
	Optional<Role> findById(Long id);
	Role save(Role role);
	void deleteById(Long id);
}
