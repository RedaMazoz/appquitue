package ma.quantorion.appquitue.apigateway.infrastructure.configurations.security;
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

import ma.quantorion.appquitue.apigateway.infrastructure.configurations.security.jwt.JwtConfig;
import ma.quantorion.appquitue.apigateway.infrastructure.configurations.security.jwt.JwtTokenVerifierFilter;
import ma.quantorion.appquitue.apigateway.infrastructure.configurations.security.jwt.JwtUsernamePasswordAuthenticationFilter;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	public JwtConfig jwtConfig;
	
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception
	{
		http
		.csrf().disable()
		.addFilter(new JwtUsernamePasswordAuthenticationFilter(authenticationManager(), jwtConfig))
		.addFilterAfter(new JwtTokenVerifierFilter(jwtConfig), JwtUsernamePasswordAuthenticationFilter.class)
		.authorizeRequests()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		;
	}
	@Bean
	public JwtConfig jwtConfigBean() {
		return new JwtConfig();
	}
	
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
	return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}


}
