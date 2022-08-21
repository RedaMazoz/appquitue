package ma.quantorion.appquitue.internshiprest.infrastructure.JPArepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.quantorion.appquitue.internshiprest.domain.Internship;
import ma.quantorion.appquitue.internshiprest.domain.InternshipRepository;

@Component
public class InternshipRepositoryAdapter implements InternshipRepository {
	private final InternshipJPARepository internshipRepository;

    @Autowired
    public InternshipRepositoryAdapter(final InternshipJPARepository internshipRepository) {
        this.internshipRepository = internshipRepository;
    }

    @Override
    public Optional<Internship> findById(Long id) {
        Optional<InternshipEntity> internshipEntity = internshipRepository.findById(id);
        if (internshipEntity.isPresent()) {
            return Optional.of(internshipEntity.get().toInternship());
        } else {
            return Optional.empty();
        }
    }

	@Override
	public List<Internship> findAll() {
		return 
		internshipRepository.findAll()
        .stream()
        .map(internshipEntity ->
          internshipEntity.toInternship())
        .collect(Collectors.toList());
	}

	@Override
	public Internship save(Internship internship) {
		internshipRepository.save(new InternshipEntity(internship));
		return internship;
	}

	@Override
	public void deleteById(Long id) {
		internshipRepository.deleteById(id);
		// TODO Auto-generated method stub
		
	}
    

}
