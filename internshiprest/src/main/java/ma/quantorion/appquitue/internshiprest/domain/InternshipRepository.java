package ma.quantorion.appquitue.internshiprest.domain;

import java.util.List;
import java.util.Optional;

public interface InternshipRepository
{
	List<Internship> findAll();
	Optional<Internship> findById(Long id);
	Internship save(Internship internship);
	void deleteById(Long id);
}
