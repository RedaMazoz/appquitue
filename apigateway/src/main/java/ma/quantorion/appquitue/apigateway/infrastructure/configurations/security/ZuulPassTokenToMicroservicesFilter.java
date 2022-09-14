package ma.quantorion.appquitue.apigateway.infrastructure.configurations.security;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import ma.quantorion.appquitue.apigateway.infrastructure.configurations.security.jwt.JwtUsernamePasswordAuthenticationFilter;

@Component
public class ZuulPassTokenToMicroservicesFilter extends ZuulFilter {

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}
	
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		
		RequestContext.getCurrentContext().addZuulRequestHeader(HttpHeaders.AUTHORIZATION, JwtUsernamePasswordAuthenticationFilter.authorizationHeaderToken);
		return null;
	}
}
