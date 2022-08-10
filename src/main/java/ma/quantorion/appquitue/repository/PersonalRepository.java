package ma.quantorion.appquitue.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.quantorion.appquitue.model.Personal;

public interface PersonalRepository extends JpaRepository<Personal, Long>
{

}
