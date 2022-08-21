package ma.quantorion.appquitue.condamnationrest;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ma.quantorion.appquitue.condamnationrest.domain.Condamnation;
import ma.quantorion.appquitue.condamnationrest.domain.CondamnationRepository;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class CondamnationrestApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CondamnationrestApplication.class, args);
	}
	
	@Autowired
	private CondamnationRepository rep;
	
	@Override
	public void run(String... args) throws Exception
	{
		rep.save(new Condamnation(1L, "nature", "periode", "motive", new Date (10,10,1980), "reference"));
	}

}
