package ma.quantorion.appquitue.authentificationrest;

import java.util.ArrayList;
import java.util.List;

import javax.management.relation.RoleNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.common.collect.Sets;

import ma.quantorion.appquitue.authentificationrest.domain.User;
import ma.quantorion.appquitue.authentificationrest.domain.ApplicationUserPermission;
import ma.quantorion.appquitue.authentificationrest.domain.Role;
import ma.quantorion.appquitue.authentificationrest.domain.RoleRepository;
import ma.quantorion.appquitue.authentificationrest.domain.UserRepository;

@SpringBootApplication
public class AuthentificationrestApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AuthentificationrestApplication.class, args);
	}
	
	@Autowired
	private UserRepository rep;
	
	@Autowired
	private RoleRepository rep2;
	
	@Override
	public void run(String... args) throws Exception
	{
//		Role admin = new Role("ROLE_TESTP", Sets.newHashSet( ApplicationUserPermission.PUNISHMENT_READ, ApplicationUserPermission.PUNISHMENT_WRITE));
//		List<Role> roleList = new ArrayList<Role>();
//		roleList.add(admin);
//		rep.save(new User(2L, "test2@test.test", "test2", roleList));
	}

}
