package com.example.security.oauth2.pwdgrant;

import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Configuration
@EnableResourceServer
public class ResourceServerConfiguration /*extends ResourceServerConfigurerAdapter*/ {

	/*private static final String RESOURCE_ID = "my_rest_api";
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		//resources.resourceId(RESOURCE_ID).stateless(false);
		resources.resourceId(RESOURCE_ID);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.
		anonymous().disable()
		.requestMatchers().antMatchers("/user/**")
		.and().authorizeRequests()
		.antMatchers("/user/**").access("hasRole('ADMIN')")
		.and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
	}*/
	
	@RequestMapping("/test")
	public String test() {
		return "Hello World with Oauth2";
	}

}