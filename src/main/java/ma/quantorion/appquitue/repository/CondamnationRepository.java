package ma.quantorion.appquitue.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.quantorion.appquitue.model.Condamnation;

public interface CondamnationRepository extends JpaRepository<Condamnation, Long>
{

}