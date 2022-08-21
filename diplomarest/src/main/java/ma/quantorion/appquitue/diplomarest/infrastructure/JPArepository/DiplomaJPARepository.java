package ma.quantorion.appquitue.diplomarest.infrastructure.JPArepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DiplomaJPARepository extends JpaRepository<DiplomaEntity, Long>  
{

}
