package com.example.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration  {
	
	private String REALM="REAME"; 
	
	@Bean
	BCryptPasswordEncoder passwordEconder() {
		return new BCryptPasswordEncoder();
	}
	
/*
	@Bean
    UserDetailsService userDetailServices() {
		UserBuilder users = User.builder();
		
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		
		manager.createUser(users
				.username("Pr")
				.password(new BCryptPasswordEncoder().encode("Test"))
				.roles("USER")
				.build());
		
		manager.createUser(users
				.username("Admin")
				.password(new BCryptPasswordEncoder().encode("Admin"))
				.roles("USER","ADMIN")
				.build());
	
		return manager;
	}
*/	
	
//	private static final String[] USER_MATCHER= {"api/v1/universita/students/**"};
	private static final String[] ADMIN_MATCHER= {"/api/v1/universita/addstudent/**"};
	
	@Bean
	SecurityFilterChain filterSecurity(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
        	.authorizeHttpRequests
        		(
        		httpsecreq -> 
        		// Gestione autorizzazione end point
        		httpsecreq
  //      		.requestMatchers(USER_MATCHER).hasAnyRole("USER")
            	.requestMatchers(ADMIN_MATCHER).hasAnyRole("ADMIN")
            	// Ogni riciesta richiede l'autenticazione
            	.anyRequest().authenticated()
            	
            	)
        		// Gestione Custoom degli Errori 
            	.httpBasic
            	(httpSecurityAuth ->
            		httpSecurityAuth
            		.realmName(REALM).authenticationEntryPoint(getAuthentucationEntryPoint())
            	)
            	// Gestione della Session
            	.sessionManagement
            	(
            		httpSecuritySession -> httpSecuritySession.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            	);
            	return http.build();
            	
		
   	}

	@Bean
	AuthenticationEntryPoint getAuthentucationEntryPoint() {
		return new AuthEntryPoint();
	}
	
	public void configure(WebSecurity web) {
		web.ignoring().requestMatchers(HttpMethod.OPTIONS,"/**");
	}

}
