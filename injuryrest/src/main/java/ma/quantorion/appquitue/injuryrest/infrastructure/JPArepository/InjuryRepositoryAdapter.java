package ma.quantorion.appquitue.injuryrest.infrastructure.JPArepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.quantorion.appquitue.injuryrest.domain.Injury;
import ma.quantorion.appquitue.injuryrest.domain.InjuryRepository;

@Component
public class InjuryRepositoryAdapter implements InjuryRepository {
	private final InjuryJPARepository injuryRepository;

    @Autowired
    public InjuryRepositoryAdapter(final InjuryJPARepository injuryRepository) {
        this.injuryRepository = injuryRepository;
    }

    @Override
    public Optional<Injury> findById(Long id) {
        Optional<InjuryEntity> injuryEntity = injuryRepository.findById(id);
        if (injuryEntity.isPresent()) {
            return Optional.of(injuryEntity.get().toInjury());
        } else {
            return Optional.empty();
        }
    }

	@Override
	public List<Injury> findAll() {
		return 
		injuryRepository.findAll()
        .stream()
        .map(injuryEntity ->
          injuryEntity.toInjury())
        .collect(Collectors.toList());
	}

	@Override
	public Injury save(Injury injury) {
		injuryRepository.save(new InjuryEntity(injury));
		return injury;
	}

	@Override
	public void deleteById(Long id) {
		injuryRepository.deleteById(id);
		// TODO Auto-generated method stub
		
	}
    

}
