package ma.quantorion.appquitue.internshiprest.infrastructure.JPArepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InternshipJPARepository extends JpaRepository<InternshipEntity, Long>  
{

}
