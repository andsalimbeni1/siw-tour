package it.uniroma3.siw.tour.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Attrazione {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank(message="Inserire un nome")
	private String nome;
	
	@NotBlank(message="Inserire una descrizione")
	private String descrizione;
}
