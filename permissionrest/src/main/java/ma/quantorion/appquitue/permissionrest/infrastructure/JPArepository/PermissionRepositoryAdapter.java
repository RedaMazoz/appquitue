package ma.quantorion.appquitue.permissionrest.infrastructure.JPArepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.quantorion.appquitue.permissionrest.domain.Permission;
import ma.quantorion.appquitue.permissionrest.domain.PermissionRepository;

@Component
public class PermissionRepositoryAdapter implements PermissionRepository {
	private final PermissionJPARepository permissionRepository;

    @Autowired
    public PermissionRepositoryAdapter(final PermissionJPARepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    @Override
    public Optional<Permission> findById(Long id) {
        Optional<PermissionEntity> permissionEntity = permissionRepository.findById(id);
        if (permissionEntity.isPresent()) {
            return Optional.of(permissionEntity.get().toPermission());
        } else {
            return Optional.empty();
        }
    }

	@Override
	public List<Permission> findAll() {
		return 
		permissionRepository.findAll()
        .stream()
        .map(permissionEntity ->
          permissionEntity.toPermission())
        .collect(Collectors.toList());
	}

	@Override
	public Permission save(Permission permission) {
		permissionRepository.save(new PermissionEntity(permission));
		return permission;
	}

	@Override
	public void deleteById(Long id) {
		permissionRepository.deleteById(id);
		// TODO Auto-generated method stub
		
	}
    

}
