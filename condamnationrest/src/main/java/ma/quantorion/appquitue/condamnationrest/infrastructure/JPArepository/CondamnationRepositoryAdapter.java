package ma.quantorion.appquitue.condamnationrest.infrastructure.JPArepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.quantorion.appquitue.condamnationrest.domain.Condamnation;
import ma.quantorion.appquitue.condamnationrest.domain.CondamnationRepository;

@Component
public class CondamnationRepositoryAdapter implements CondamnationRepository {
	private final CondamnationJPARepository condamnationRepository;

    @Autowired
    public CondamnationRepositoryAdapter(final CondamnationJPARepository condamnationRepository) {
        this.condamnationRepository = condamnationRepository;
    }

    @Override
    public Optional<Condamnation> findById(Long id) {
        Optional<CondamnationEntity> condamnationEntity = condamnationRepository.findById(id);
        if (condamnationEntity.isPresent()) {
            return Optional.of(condamnationEntity.get().toCondamnation());
        } else {
            return Optional.empty();
        }
    }

	@Override
	public List<Condamnation> findAll() {
		return 
		condamnationRepository.findAll()
        .stream()
        .map(condamnationEntity ->
          condamnationEntity.toCondamnation())
        .collect(Collectors.toList());
	}

	@Override
	public Condamnation save(Condamnation condamnation) {
		condamnationRepository.save(new CondamnationEntity(condamnation));
		return condamnation;
	}

	@Override
	public void deleteById(Long id) {
		condamnationRepository.deleteById(id);
		// TODO Auto-generated method stub
		
	}
    

}
