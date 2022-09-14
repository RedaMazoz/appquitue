package ma.quantorion.appquitue.apigateway.infrastructure.JPArepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserJPARepository extends JpaRepository<UserEntity, Long>  
{
	public UserEntity findByEmail(String email);
}
