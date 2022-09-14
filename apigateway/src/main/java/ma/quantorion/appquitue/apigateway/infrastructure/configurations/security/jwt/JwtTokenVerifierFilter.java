package ma.quantorion.appquitue.apigateway.infrastructure.configurations.security.jwt;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.google.common.base.Strings;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JwtTokenVerifierFilter extends OncePerRequestFilter {

	private final JwtConfig jwtConfig;
	
	public JwtTokenVerifierFilter(JwtConfig jwtConfig)
	{
		this.jwtConfig = jwtConfig;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String authorizationHeader = request.getHeader(jwtConfig.getAuthorizationHeader());
		
		if(Strings.isNullOrEmpty(authorizationHeader) || !authorizationHeader.startsWith(jwtConfig.getTokenPrefix())) {
			filterChain.doFilter(request, response);
			return;
		}
		
		String userToken = authorizationHeader.replace(jwtConfig.getTokenPrefix(), "");
		
		//System.out.println(userToken);
		
		try
		{	
			Jws<Claims> claimsJws = Jwts.parser()
				.setSigningKey(Keys.hmacShaKeyFor(jwtConfig.getSecretKey().getBytes()))
				.parseClaimsJws(userToken);
			
			Claims body = claimsJws.getBody();
			
			String username = body.getSubject();
			
			List<Map<String,String>> authoritiesHeader = (List<Map<String,String>>) body.get("authorities");
			
			
			Set<SimpleGrantedAuthority> authorities = authoritiesHeader.stream()
				.map(authorityItem -> new SimpleGrantedAuthority(authorityItem.get("authority")))
				.collect(Collectors.toSet());
			
			Authentication authentication = new UsernamePasswordAuthenticationToken(username, null, authorities);
			SecurityContextHolder.getContext().setAuthentication(authentication);
		} catch(JwtException e)
		{
			throw new IllegalStateException(String.format("Token %s cannot be trusted", userToken)); 
		}
		
		filterChain.doFilter(request, response);
		
		
		
	}

}
