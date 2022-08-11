package ma.quantorion.appquitue.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.quantorion.appquitue.model.Mission;

public interface MissionRepository extends JpaRepository<Mission, Long>
{

}