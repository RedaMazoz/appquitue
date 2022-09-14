package ma.quantorion.appquitue.apigateway.infrastructure.JPArepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.quantorion.appquitue.apigateway.domain.Role;
import ma.quantorion.appquitue.apigateway.domain.RoleRepository;

@Component
public class RoleRepositoryAdapter implements RoleRepository {
	private final RoleJPARepository roleRepository;

    @Autowired
    public RoleRepositoryAdapter(final RoleJPARepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Optional<Role> findById(Long id) {
        Optional<RoleEntity> roleEntity = roleRepository.findById(id);
        if (roleEntity.isPresent()) {
            return Optional.of(roleEntity.get().toRole());
        } else {
            return Optional.empty();
        }
    }

	@Override
	public List<Role> findAll() {
		return 
		roleRepository.findAll()
        .stream()
        .map(roleEntity ->
          roleEntity.toRole())
        .collect(Collectors.toList());
	}

	@Override
	public Role save(Role role) {
		roleRepository.save(new RoleEntity(role));
		return role;
	}

	@Override
	public void deleteById(Long id) {
		roleRepository.deleteById(id);
		// TODO Auto-generated method stub
		
	}
    

}
