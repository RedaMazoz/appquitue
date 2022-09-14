package ma.quantorion.appquitue.apigateway;

import java.util.ArrayList;
import java.util.List;

import javax.management.relation.RoleNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import com.google.common.collect.Sets;

import ma.quantorion.appquitue.apigateway.domain.ApplicationUserPermission;
import ma.quantorion.appquitue.apigateway.domain.Role;
import ma.quantorion.appquitue.apigateway.domain.RoleRepository;
import ma.quantorion.appquitue.apigateway.domain.User;
import ma.quantorion.appquitue.apigateway.domain.UserRepository;

@EnableZuulProxy
@SpringBootApplication
public class ApigatewayApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ApigatewayApplication.class, args);
	}
	
	@Autowired
	private UserRepository rep;
	
	@Autowired
	private RoleRepository rep2;
	
	@Override
	public void run(String... args) throws Exception
	{
		Role admin = new Role("ROLE_BIG_ADMIN", Sets.newHashSet( ApplicationUserPermission.PERSONAL_READ, ApplicationUserPermission.PERSONAL_WRITE, ApplicationUserPermission.PUNISHMENT_READ, ApplicationUserPermission.PUNISHMENT_WRITE, ApplicationUserPermission.PERMISSION_READ, ApplicationUserPermission.PERMISSION_WRITE, ApplicationUserPermission.MISSION_READ, ApplicationUserPermission.MISSION_WRITE, ApplicationUserPermission.INTERNSHIP_READ, ApplicationUserPermission.INTERNSHIP_WRITE, ApplicationUserPermission.INJURY_READ, ApplicationUserPermission.INJURY_WRITE, ApplicationUserPermission.DIPLOMA_READ, ApplicationUserPermission.DIPLOMA_WRITE, ApplicationUserPermission.CONDAMNATION_READ, ApplicationUserPermission.CONDAMNATION_WRITE));
		rep2.save(admin);
		List<Role> roleList = new ArrayList<Role>();
		roleList.add(admin);
		
		rep.save(new User(1L, "admin@admin.admin", "admin", roleList));
	}

}
