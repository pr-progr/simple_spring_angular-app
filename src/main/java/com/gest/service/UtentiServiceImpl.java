package com.gest.service;

import org.springframework.stereotype.Service;

import com.gest.domain.Utente;
import com.gest.repository.UtentiRepository;

import lombok.SneakyThrows;

@Service
public class UtentiServiceImpl implements UtentiService {
	
	private final UtentiRepository utentiRepository;

	
	
	public UtentiServiceImpl(UtentiRepository utentiRepository) {
		this.utentiRepository = utentiRepository;
	}

	@Override
	@SneakyThrows
	public void inserisci(Utente utente) {
		if(cerca(utente.getUserId()) == null) {
			utentiRepository.save(utente);
		}else {
			/**
			 * Gestire Eccezione - Utente già inserito
			 */
		}
	}

	@Override
	public Utente cerca(String userId)
	{
		return utentiRepository.findByUserId(userId);
		
	}

}
