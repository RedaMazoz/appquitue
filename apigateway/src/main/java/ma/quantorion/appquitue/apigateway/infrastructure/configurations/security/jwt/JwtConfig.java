package ma.quantorion.appquitue.apigateway.infrastructure.configurations.security.jwt;

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
	private int tokenExpirationAfterDays;
 	private String tokenPrefix;
 	
 	public String getAuthorizationHeader() {
 		return HttpHeaders.AUTHORIZATION;
 	}
}
