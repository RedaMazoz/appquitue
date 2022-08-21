package ma.quantorion.appquitue.personalrest.domain;

import java.util.List;
import java.util.Optional;

public interface PersonalRepository
{
	List<Personal> findAll();
	Optional<Personal> findById(Long id);
	Personal save(Personal personal);
	void deleteById(Long id);
}
