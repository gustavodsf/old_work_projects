package br.gov.rj.mis.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Estado implements Serializable {
	

	private static final long serialVersionUID = 1L;

	@SequenceGenerator(name="ESTADO_SEQUENCE_GENERATOR", sequenceName="ESTADO_SEQUENCE", initialValue=1, allocationSize=1)
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ESTADO_SEQUENCE_GENERATOR")
	private Long id;
	
	@Column(length=20)
	private String nome;
	
	@Column(length=2)
	private String sigla;
	/*Clear*/
	public void clear(){
		this.setId(null);
		this.setNome(null);
		this.setSigla(null);
	}

	/* Getters and Setters */
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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
}
