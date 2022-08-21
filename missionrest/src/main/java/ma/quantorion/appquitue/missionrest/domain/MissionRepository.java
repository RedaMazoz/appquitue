package ma.quantorion.appquitue.missionrest.domain;

import java.util.List;
import java.util.Optional;

public interface MissionRepository
{
	List<Mission> findAll();
	Optional<Mission> findById(Long id);
	Mission save(Mission mission);
	void deleteById(Long id);
}
