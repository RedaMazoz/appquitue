package ma.quantorion.appquitue.permissionrest;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ma.quantorion.appquitue.permissionrest.domain.Permission;
import ma.quantorion.appquitue.permissionrest.domain.PermissionRepository;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class PermissionrestApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PermissionrestApplication.class, args);
	}
	
	@Autowired
	private PermissionRepository rep;
	
	@Override
	public void run(String... args) throws Exception
	{
		rep.save(new Permission(1L,"Type", new Date(10,10,1960), new Date (10,10,1980), "observation", "destination"));
	}

}
