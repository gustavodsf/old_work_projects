package br.gov.rj.mis.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;



@Entity
public class Setor implements Serializable {
	

	private static final long serialVersionUID = 1L;

	@SequenceGenerator(name="SETOR_SEQUENCE_GENERATOR", sequenceName="SETOR_SEQUENCE", initialValue=1, allocationSize=1)
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SETOR_SEQUENCE_GENERATOR")
	private Long id;
	
	@Column(name="nome_exibido",length=45)
	private String nomeExibido;
	
	@Column(name="nome_sistema",length=45)
	private String nomeSistema;
	
	/*Clear*/
	public void clear(){
		this.setId(null);
		this.setNomeExibido(null);
		this.setNomeSistema(null);
	}
	
	/*Getter and Setter*/
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNomeExibido() {
		return nomeExibido;
	}
	public void setNomeExibido(String nomeExibido) {
		this.nomeExibido = nomeExibido;
	}
	
	public String getNomeSistema() {
		return nomeSistema;
	}
	public void setNomeSistema(String nomeSistema) {
		this.nomeSistema = nomeSistema;
	}
}
