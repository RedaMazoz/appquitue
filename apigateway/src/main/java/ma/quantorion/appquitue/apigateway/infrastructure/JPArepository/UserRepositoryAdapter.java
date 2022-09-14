package ma.quantorion.appquitue.apigateway.infrastructure.JPArepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.quantorion.appquitue.apigateway.domain.User;
import ma.quantorion.appquitue.apigateway.domain.UserRepository;

@Component
public class UserRepositoryAdapter implements UserRepository {
	private final UserJPARepository userRepository;

    @Autowired
    public UserRepositoryAdapter(final UserJPARepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Override
    public User findByEmail(String email)
    {
    	return userRepository.findByEmail(email).toUser();
    }

    @Override
    public Optional<User> findById(Long id) {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        if (userEntity.isPresent()) {
            return Optional.of(userEntity.get().toUser());
        } else {
            return Optional.empty();
        }
    }

	@Override
	public List<User> findAll() {
		return 
		userRepository.findAll()
        .stream()
        .map(userEntity ->
          userEntity.toUser())
        .collect(Collectors.toList());
	}

	@Override
	public User save(User user) {
		userRepository.save(new UserEntity(user));
		return user;
	}

	@Override
	public void deleteById(Long id) {
		userRepository.deleteById(id);
		// TODO Auto-generated method stub
		
	}
    

}
