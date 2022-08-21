package ma.quantorion.appquitue.punishmentrest.infrastructure.JPArepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PunishmentJPARepository extends JpaRepository<PunishmentEntity, Long>  
{

}
