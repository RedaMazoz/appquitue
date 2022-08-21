package ma.quantorion.appquitue.personalrest.infrastructure.JPArepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonalJPARepository extends JpaRepository<PersonalEntity, Long>  
{

}
