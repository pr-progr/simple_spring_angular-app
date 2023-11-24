package com.gest.service;

import com.gest.domain.Utente;

public interface UtentiService {
	
	void inserisci(Utente utente);
	
	Utente cerca(String userId);

}
