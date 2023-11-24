package com.gest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gest.domain.Utente;
import com.gest.service.UtentiService;

@RestController
@RequestMapping(value = "/api/utenti")
public class UtentiController {
	
	private final UtentiService utentiService;
	private final BCryptPasswordEncoder passwordEncoder;
	
	public UtentiController(UtentiService utentiService) {
		this.utentiService = utentiService;
		this.passwordEncoder = new BCryptPasswordEncoder();
	}


	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping(value = "/inserisci")
	public void inserisciUtente(@RequestBody Utente utente){
		utente.setPassword(passwordEncoder.encode(utente.getPassword()));
		utentiService.inserisci(utente);
	}
	
	@GetMapping(value = "/cerca/uente/{idUser}")
	public Utente getUteneByIdUser(@PathVariable String idUser) {
		return utentiService.cerca(idUser);
	}
}
