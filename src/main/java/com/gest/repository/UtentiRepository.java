package com.gest.repository;

import org.springframework.data.repository.CrudRepository;

import com.gest.domain.Utente;

public interface UtentiRepository extends CrudRepository<Utente, Long> {
	
	Utente findByUserId(String userId);

}
