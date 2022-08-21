package ma.quantorion.appquitue.injuryrest;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ma.quantorion.appquitue.injuryrest.domain.Injury;
import ma.quantorion.appquitue.injuryrest.domain.InjuryRepository;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class InjuryrestApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(InjuryrestApplication.class, args);
	}
	
	@Autowired
	private InjuryRepository rep;
	
	@Override
	public void run(String... args) throws Exception
	{
		rep.save(new Injury(1L, "type", new Date(10,10,1960), "place"));
	}

}
