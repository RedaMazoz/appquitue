package ma.quantorion.appquitue.missionrest.infrastructure.JPArepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MissionJPARepository extends JpaRepository<MissionEntity, Long>  
{

}
