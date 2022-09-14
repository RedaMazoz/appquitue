package ma.quantorion.appquitue.condamnationrest.infrastructure.configurations.security.jwt;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.google.common.net.HttpHeaders;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ConfigurationProperties(prefix= "application.jwt")
public class JwtConfig {
	private String secretKey;
 	private String tokenPrefix;
 	
 	public String getAuthorizationHeader() {
 		return HttpHeaders.AUTHORIZATION;
 	}
 	
 	
 	//Singleton
 	private static final JwtConfig INSTANCE = new JwtConfig();
 	
 	public static JwtConfig getInstance() {
 		return INSTANCE;
 	}
}
