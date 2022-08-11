package ma.quantorion.appquitue.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.quantorion.appquitue.model.Punishment;

public interface PunishmentRepository extends JpaRepository<Punishment, Long>
{

}