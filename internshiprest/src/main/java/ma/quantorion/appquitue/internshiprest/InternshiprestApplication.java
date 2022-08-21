package ma.quantorion.appquitue.internshiprest;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ma.quantorion.appquitue.internshiprest.domain.Internship;
import ma.quantorion.appquitue.internshiprest.domain.InternshipRepository;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class InternshiprestApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(InternshiprestApplication.class, args);
	}
	
	@Autowired
	private InternshipRepository rep;
	
	@Override
	public void run(String... args) throws Exception
	{
		rep.save(new Internship(1L, "designation", new Date(10,10,1960), new Date(10,10,1960), "place", "reference"));
	}

}
