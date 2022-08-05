package ma.quantorion.appquitue.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.quantorion.appquitue.model.Personnel;

public interface PersonnelRepository extends JpaRepository<Personnel, Long>
{

}
