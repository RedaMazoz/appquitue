package ma.quantorion.appquitue.condamnationrest.infrastructure.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import ma.quantorion.appquitue.condamnationrest.infrastructure.JPArepository.CondamnationJPARepository;

@Configuration
@EnableJpaRepositories(basePackageClasses = CondamnationJPARepository.class)
public class JPAConfiguration {

}
