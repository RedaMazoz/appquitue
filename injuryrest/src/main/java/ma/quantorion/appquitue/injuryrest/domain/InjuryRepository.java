package ma.quantorion.appquitue.injuryrest.domain;

import java.util.List;
import java.util.Optional;

public interface InjuryRepository
{
	List<Injury> findAll();
	Optional<Injury> findById(Long id);
	Injury save(Injury injury);
	void deleteById(Long id);
}
