package ma.quantorion.appquitue.injuryrest.infrastructure.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import ma.quantorion.appquitue.injuryrest.infrastructure.JPArepository.InjuryJPARepository;

@Configuration
@EnableJpaRepositories(basePackageClasses = InjuryJPARepository.class)
public class JPAConfiguration {

}
