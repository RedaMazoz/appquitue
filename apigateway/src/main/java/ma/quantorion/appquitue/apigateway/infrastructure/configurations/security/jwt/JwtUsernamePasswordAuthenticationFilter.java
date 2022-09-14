package ma.quantorion.appquitue.apigateway.infrastructure.configurations.security.jwt;


import java.time.LocalDate;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.IOException;
import io.jsonwebtoken.security.Keys;

public class JwtUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter{

	public JwtConfig jwtConfig;
	private final AuthenticationManager authManager;
	
	public static String authorizationHeaderToken;
	
	public JwtUsernamePasswordAuthenticationFilter(AuthenticationManager authManager, JwtConfig jwtConfig)
	{
		this.authManager = authManager;
		this.jwtConfig = jwtConfig;
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		
		try {
		
		//In case you we are using basicAuth not formLogin 
		//UsernameAndPasswordAuthenticationRequest authRequest = new ObjectMapper().readValue(request.getInputStream(), UsernameAndPasswordAuthenticationRequest.class);
		
		//In case you we are using formLogin
		UsernameAndPasswordAuthenticationRequest authRequest = new UsernameAndPasswordAuthenticationRequest(request.getParameter("username"),request.getParameter("password"));
		
		Authentication authentication = new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword());
		
		return authManager.authenticate(authentication);
		
		} catch(IOException e)
		{
			throw new RuntimeException(e);
		} 
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws java.io.IOException, ServletException {

			String token = Jwts.builder()
				.setSubject(authResult.getName())
				.claim("authorities", authResult.getAuthorities())
				.setIssuedAt(new Date())
				.setExpiration(java.sql.Date.valueOf(LocalDate.now().plusDays(jwtConfig.getTokenExpirationAfterDays())))
				.signWith(Keys.hmacShaKeyFor(jwtConfig.getSecretKey().getBytes()))
				.compact();
			
			//For the Zuul filter to pass to Microservices
			authorizationHeaderToken = jwtConfig.getTokenPrefix() + token;
			
			//Sending generated token to users
			response.addHeader(jwtConfig.getAuthorizationHeader(), authorizationHeaderToken);
		
		super.successfulAuthentication(request, response, chain, authResult);
	}

}
