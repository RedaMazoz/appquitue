package ma.quantorion.appquitue.diplomarest;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ma.quantorion.appquitue.diplomarest.domain.Diploma;
import ma.quantorion.appquitue.diplomarest.domain.DiplomaRepository;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class DiplomarestApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DiplomarestApplication.class, args);
	}
	
	@Autowired
	private DiplomaRepository rep;
	
	@Override
	public void run(String... args) throws Exception
	{
		rep.save(new Diploma(1L, "universitaire","Diplome d'Ingenieur", new Date(10,10,1960)));
	}

}
