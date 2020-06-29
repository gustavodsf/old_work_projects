package br.gov.rj.mis.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Cargo  implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@SequenceGenerator(name="CARGO_SEQUENCE_GENERATOR", sequenceName="CARGO_SEQUENCE", initialValue=1, allocationSize=1)
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CARGO_SEQUENCE_GENERATOR")
	private Long id;
	
	@Column(name="nome_sistema",length=40)
	private String nomeSistema;
	
	@Column(name="nome_exibido",length=40)
	private String nomeExibido;
	
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
	
	public String getNomeSistema() {
		return nomeSistema;
	}
	public void setNomeSistema(String nomeSistema) {
		this.nomeSistema = nomeSistema;
	}
	
	public String getNomeExibido() {
		return nomeExibido;
	}
	public void setNomeExibido(String nomeExibido) {
		this.nomeExibido = nomeExibido;
	}

}
