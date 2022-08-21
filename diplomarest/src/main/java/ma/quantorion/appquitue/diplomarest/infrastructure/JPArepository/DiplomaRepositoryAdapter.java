package ma.quantorion.appquitue.diplomarest.infrastructure.JPArepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.quantorion.appquitue.diplomarest.domain.Diploma;
import ma.quantorion.appquitue.diplomarest.domain.DiplomaRepository;

@Component
public class DiplomaRepositoryAdapter implements DiplomaRepository {
	private final DiplomaJPARepository diplomaRepository;

    @Autowired
    public DiplomaRepositoryAdapter(final DiplomaJPARepository diplomaRepository) {
        this.diplomaRepository = diplomaRepository;
    }

    @Override
    public Optional<Diploma> findById(Long id) {
        Optional<DiplomaEntity> diplomaEntity = diplomaRepository.findById(id);
        if (diplomaEntity.isPresent()) {
            return Optional.of(diplomaEntity.get().toDiploma());
        } else {
            return Optional.empty();
        }
    }

	@Override
	public List<Diploma> findAll() {
		return 
		diplomaRepository.findAll()
        .stream()
        .map(diplomaEntity ->
          diplomaEntity.toDiploma())
        .collect(Collectors.toList());
	}

	@Override
	public Diploma save(Diploma diploma) {
		diplomaRepository.save(new DiplomaEntity(diploma));
		return diploma;
	}

	@Override
	public void deleteById(Long id) {
		diplomaRepository.deleteById(id);
		// TODO Auto-generated method stub
		
	}
    

}
