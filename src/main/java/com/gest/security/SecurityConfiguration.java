package com.gest.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	private static final String[] ADMIN_MATCHER= {"/api/utenti/inserisci/"};
	
	@Bean
	protected SecurityFilterChain configure(HttpSecurity http) throws Exception{
        http.csrf(csrf -> csrf.disable())
        	.authorizeHttpRequests
        	((httpRequest) ->
        		httpRequest
        		.requestMatchers(ADMIN_MATCHER).hasAnyRole("ADMIN")
        		.anyRequest().authenticated()
        				   
        	)
        	.httpBasic(Customizer.withDefaults())
        	.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        	
        	;
		
		return http.build();
		
	}
}
