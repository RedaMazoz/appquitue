package ma.quantorion.appquitue.condamnationrest.domain;

import java.util.List;
import java.util.Optional;

public interface CondamnationRepository
{
	List<Condamnation> findAll();
	Optional<Condamnation> findById(Long id);
	Condamnation save(Condamnation condamnation);
	void deleteById(Long id);
}
