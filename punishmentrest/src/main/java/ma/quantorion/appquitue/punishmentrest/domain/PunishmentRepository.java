package ma.quantorion.appquitue.punishmentrest.domain;

import java.util.List;
import java.util.Optional;

public interface PunishmentRepository
{
	List<Punishment> findAll();
	Optional<Punishment> findById(Long id);
	Punishment save(Punishment punishment);
	void deleteById(Long id);
}
