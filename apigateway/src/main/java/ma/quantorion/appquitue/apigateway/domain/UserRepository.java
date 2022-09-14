package ma.quantorion.appquitue.apigateway.domain;

import java.util.List;
import java.util.Optional;

public interface UserRepository
{
	List<User> findAll();
	Optional<User> findById(Long id);
	User findByEmail(String email);
	User save(User user);
	void deleteById(Long id);
}
