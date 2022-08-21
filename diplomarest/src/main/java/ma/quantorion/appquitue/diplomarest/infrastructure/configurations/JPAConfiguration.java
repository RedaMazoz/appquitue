package ma.quantorion.appquitue.diplomarest.infrastructure.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import ma.quantorion.appquitue.diplomarest.infrastructure.JPArepository.DiplomaJPARepository;

@Configuration
@EnableJpaRepositories(basePackageClasses = DiplomaJPARepository.class)
public class JPAConfiguration {

}
