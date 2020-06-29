package br.gov.rj.mis.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Idioma implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@SequenceGenerator(name="IDIOMA_SEQUENCE_GENERATOR", sequenceName="IDIOMA_SEQUENCE", initialValue=1, allocationSize=1)
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="IDIOMA_SEQUENCE_GENERATOR")
	public Long id;
	
	@Column(nullable=false, unique=true, length=80)
	public String nome;
	
	@Column(name="estado_registro", length=20, nullable=false)
	private String estado;
	
	/*Clear*/
	public void clear(){
		this.setId(null);
		this.setNome(null);
		this.setEstado(null);
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
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
}
