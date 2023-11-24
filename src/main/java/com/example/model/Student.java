package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString.Exclude;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Exclude
	private Integer id;
	
	private String nome;
	private String cognome;
	private String matricola;
	
	



	
	
	

}
