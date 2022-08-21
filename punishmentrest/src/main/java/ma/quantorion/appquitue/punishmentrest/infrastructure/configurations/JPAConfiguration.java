package ma.quantorion.appquitue.punishmentrest.infrastructure.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import ma.quantorion.appquitue.punishmentrest.infrastructure.JPArepository.PunishmentJPARepository;

@Configuration
@EnableJpaRepositories(basePackageClasses = PunishmentJPARepository.class)
public class JPAConfiguration {

}
