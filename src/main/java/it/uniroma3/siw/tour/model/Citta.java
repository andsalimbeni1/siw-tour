package it.uniroma3.siw.tour.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Citta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank(message="Inserire un nome")
	private String nome;
	
	@ManyToMany(mappedBy="citta")
	private Escursione escursione;
	
	@ManyToOne
	@JoinColumn(name="regione_id")
	private Regione regione;
	
	@OneToMany
	@JoinColumn(name="attrazione_id")
	private Attrazione attrazioni;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Escursione getEscursione() {
		return escursione;
	}

	public void setEscursione(Escursione escursione) {
		this.escursione = escursione;
	}

	public Regione getRegione() {
		return regione;
	}

	public void setRegione(Regione regione) {
		this.regione = regione;
	}

	public Attrazione getAttrazioni() {
		return attrazioni;
	}

	public void setAttrazioni(Attrazione attrazioni) {
		this.attrazioni = attrazioni;
	}
}
