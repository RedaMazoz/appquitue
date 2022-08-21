package ma.quantorion.appquitue.punishmentrest;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ma.quantorion.appquitue.punishmentrest.domain.Punishment;
import ma.quantorion.appquitue.punishmentrest.domain.PunishmentRepository;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class PunishmentrestApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PunishmentrestApplication.class, args);
	}
	
	@Autowired
	private PunishmentRepository rep;
	
	@Override
	public void run(String... args) throws Exception
	{
		rep.save(new Punishment(1L, 10, "motive", new Date(10,10,1960)));
	}

}
