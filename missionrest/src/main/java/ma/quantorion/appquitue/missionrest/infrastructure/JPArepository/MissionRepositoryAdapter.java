package ma.quantorion.appquitue.missionrest.infrastructure.JPArepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.quantorion.appquitue.missionrest.domain.Mission;
import ma.quantorion.appquitue.missionrest.domain.MissionRepository;

@Component
public class MissionRepositoryAdapter implements MissionRepository {
	private final MissionJPARepository missionRepository;

    @Autowired
    public MissionRepositoryAdapter(final MissionJPARepository missionRepository) {
        this.missionRepository = missionRepository;
    }

    @Override
    public Optional<Mission> findById(Long id) {
        Optional<MissionEntity> missionEntity = missionRepository.findById(id);
        if (missionEntity.isPresent()) {
            return Optional.of(missionEntity.get().toMission());
        } else {
            return Optional.empty();
        }
    }

	@Override
	public List<Mission> findAll() {
		return 
		missionRepository.findAll()
        .stream()
        .map(missionEntity ->
          missionEntity.toMission())
        .collect(Collectors.toList());
	}

	@Override
	public Mission save(Mission mission) {
		missionRepository.save(new MissionEntity(mission));
		return mission;
	}

	@Override
	public void deleteById(Long id) {
		missionRepository.deleteById(id);
		// TODO Auto-generated method stub
		
	}
    

}
