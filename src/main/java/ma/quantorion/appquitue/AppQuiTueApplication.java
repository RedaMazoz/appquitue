package ma.quantorion.appquitue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ma.quantorion.appquitue.domain.PersonnelService;
import ma.quantorion.appquitue.model.Personnel;
import ma.quantorion.appquitue.repository.PersonnelRepository;

@SpringBootApplication
public class AppQuiTueApplication implements CommandLineRunner{
	
	public static void main(String[] args) {
		SpringApplication.run(AppQuiTueApplication.class, args);
	}
	
	@Autowired
	private PersonnelRepository rep;
	
	@Override
	public void run(String... args) throws Exception
	{
		rep.save(new Personnel("reda", "mazoz"));
	}

}
