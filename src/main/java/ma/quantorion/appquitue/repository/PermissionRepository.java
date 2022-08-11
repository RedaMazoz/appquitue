package ma.quantorion.appquitue.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.quantorion.appquitue.model.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Long>
{

}