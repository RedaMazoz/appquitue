package ma.quantorion.appquitue.permissionrest.infrastructure.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import ma.quantorion.appquitue.permissionrest.infrastructure.JPArepository.PermissionJPARepository;

@Configuration
@EnableJpaRepositories(basePackageClasses = PermissionJPARepository.class)
public class JPAConfiguration {

}
