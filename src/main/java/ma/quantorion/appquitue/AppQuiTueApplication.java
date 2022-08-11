package ma.quantorion.appquitue;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ma.quantorion.appquitue.domain.interfaces.PersonalService;
import ma.quantorion.appquitue.model.Personal;
import ma.quantorion.appquitue.repository.PersonalRepository;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class AppQuiTueApplication implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(AppQuiTueApplication.class, args);
	}
	
	@Autowired
	private PersonalRepository rep;
	
	@Override
	public void run(String... args) throws Exception
	{
		rep.save(new Personal("Reda", "Mazoz", 06000000, new Date(10,10,1960), "Fes",
		"Sefrou", "sergent", new Date (10,10,1980), "CD456789", "AB-", "Avenue Mohammed El-Fassi, Derb el-khokha, Hay elhaj",
		"photo.jpg", "Fes", "matricule", 123456, "ccpId", 0611111111,
		"Avenue Hassan II, derb lkhobza", "Hassan Ben Jawad", "Avenue Mohamed El-Fassi, Derb el-khoka", "Couturier",
		"Fatma Bent Mohammed", "Femme au foyer", "Khadija Doughri", "Pere au Foyer", "Mohammed Ghazouani", 2,
		"celibitaire", 456789123, "unit", "currentFunction", new Date(5,10,1986),
		"affectationReference"));
	}

}
