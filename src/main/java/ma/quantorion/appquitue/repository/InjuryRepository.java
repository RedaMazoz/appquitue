package ma.quantorion.appquitue.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.quantorion.appquitue.model.Injury;

public interface InjuryRepository extends JpaRepository<Injury, Long>
{

}