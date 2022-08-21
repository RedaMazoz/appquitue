package ma.quantorion.appquitue.missionrest.infrastructure.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import ma.quantorion.appquitue.missionrest.infrastructure.JPArepository.MissionJPARepository;

@Configuration
@EnableJpaRepositories(basePackageClasses = MissionJPARepository.class)
public class JPAConfiguration {

}
