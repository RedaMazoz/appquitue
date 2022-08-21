package ma.quantorion.appquitue.condamnationrest.infrastructure.JPArepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CondamnationJPARepository extends JpaRepository<CondamnationEntity, Long>  
{

}
