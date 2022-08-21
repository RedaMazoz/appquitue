package ma.quantorion.appquitue.personalrest.infrastructure.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import ma.quantorion.appquitue.personalrest.infrastructure.JPArepository.PersonalJPARepository;

@Configuration
@EnableJpaRepositories(basePackageClasses = PersonalJPARepository.class)
public class JPAConfiguration {

}
