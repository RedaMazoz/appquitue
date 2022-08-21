package ma.quantorion.appquitue.missionrest;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ma.quantorion.appquitue.missionrest.domain.Mission;
import ma.quantorion.appquitue.missionrest.domain.MissionRepository;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class MissionrestApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MissionrestApplication.class, args);
	}
	
	@Autowired
	private MissionRepository rep;
	
	@Override
	public void run(String... args) throws Exception
	{
		rep.save(new Mission(1L, "designation", new Date(10,10,1960), new Date(10,10,1960)));
	}

}
