package ma.quantorion.appquitue.diplomarest.infrastructure.configurations.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import ma.quantorion.appquitue.diplomarest.infrastructure.configurations.security.jwt.JwtConfig;
import ma.quantorion.appquitue.diplomarest.infrastructure.configurations.security.jwt.JwtTokenVerifierFilter;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private JwtConfig jwtConfig;
	
	@Override
	public void configure(HttpSecurity http) throws Exception
	{
		http
		.csrf().disable()
		.addFilterBefore(new JwtTokenVerifierFilter(jwtConfig), BasicAuthenticationFilter.class)
		.authorizeRequests()
		.anyRequest().permitAll().and().formLogin();
	}
	@Bean
	public static JwtConfig jwtConfigBean() {
		return JwtConfig.getInstance();
	}

}
