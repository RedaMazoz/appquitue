package ma.quantorion.appquitue.diplomarest.domain;

import java.util.List;
import java.util.Optional;

public interface DiplomaRepository
{
	List<Diploma> findAll();
	Optional<Diploma> findById(Long id);
	Diploma save(Diploma diploma);
	void deleteById(Long id);
}
