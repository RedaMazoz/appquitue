package ma.quantorion.appquitue.injuryrest.infrastructure.JPArepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InjuryJPARepository extends JpaRepository<InjuryEntity, Long>  
{

}
