package ma.quantorion.appquitue.authentificationrest.infrastructure.JPArepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleJPARepository extends JpaRepository<RoleEntity, Long>  
{
	
}
