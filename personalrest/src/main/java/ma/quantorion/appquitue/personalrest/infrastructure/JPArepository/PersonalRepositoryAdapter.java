package ma.quantorion.appquitue.personalrest.infrastructure.JPArepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.quantorion.appquitue.personalrest.domain.Personal;
import ma.quantorion.appquitue.personalrest.domain.PersonalRepository;

@Component
public class PersonalRepositoryAdapter implements PersonalRepository {
	private final PersonalJPARepository personalRepository;

    @Autowired
    public PersonalRepositoryAdapter(final PersonalJPARepository personalRepository) {
        this.personalRepository = personalRepository;
    }

    @Override
    public Optional<Personal> findById(Long id) {
        Optional<PersonalEntity> personalEntity = personalRepository.findById(id);
        if (personalEntity.isPresent()) {
            return Optional.of(personalEntity.get().toPersonal());
        } else {
            return Optional.empty();
        }
    }

	@Override
	public List<Personal> findAll() {
		return 
		personalRepository.findAll()
        .stream()
        .map(personalEntity ->
          personalEntity.toPersonal())
        .collect(Collectors.toList());
	}

	@Override
	public Personal save(Personal personal) {
		personalRepository.save(new PersonalEntity(personal));
		return personal;
	}

	@Override
	public void deleteById(Long id) {
		personalRepository.deleteById(id);
		// TODO Auto-generated method stub
		
	}
    

}
