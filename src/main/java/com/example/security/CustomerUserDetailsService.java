package com.example.security;

import org.springframework.security.config.annotation.authentication.configurers.provisioning.UserDetailsManagerConfigurer.UserDetailsBuilder;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.extern.java.Log;

@Log
@Service(value  = "customerUserDetailsService")
public class CustomerUserDetailsService implements UserDetailsService
{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return null;
	}

}
