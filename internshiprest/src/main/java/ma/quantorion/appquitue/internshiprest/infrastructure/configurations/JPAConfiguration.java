package ma.quantorion.appquitue.internshiprest.infrastructure.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import ma.quantorion.appquitue.internshiprest.infrastructure.JPArepository.InternshipJPARepository;

@Configuration
@EnableJpaRepositories(basePackageClasses = InternshipJPARepository.class)
public class JPAConfiguration {

}
