package com.example.security;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.java.Log;

@Log
public class AuthEntryPoint extends BasicAuthenticationEntryPoint{
	
	private  static String REALM = "REAME";
	
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException {
	//	log.warn("Errorea Sicurezza " + authException.getMessage());
		
		log.warning("Errore Sicurezza " + authException.getMessage());
		
		String errMsg = "Username o Password errati";
		// Set Response  Status - Header 
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		response.setHeader("WWW-Authenticate", "Basic realm=" + getRealmName() + "");
		
		PrintWriter writer = response.getWriter();
		//Scrivo il messaggio Custom 
		writer.println(errMsg);
	}
	
	@Override
	public void afterPropertiesSet() {
		setRealmName(REALM);
		super.afterPropertiesSet();
	}
}
