package br.gov.rj.mis.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tipo_documental")
public class TipoDocumental implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@SequenceGenerator(name="TIPODOC_SEQUENCE_GENERATOR", sequenceName="TIPODOC_SEQUENCE", initialValue=1, allocationSize=1)
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPODOC_SEQUENCE_GENERATOR")
	private Long id;
	
	@Column(length=4)
	private String sigla;
	
	@Column(length=80, nullable=false)
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "id_setor")
	private Setor setor;
	
	@Column(name="estado_registro", length=20, nullable=false)
	private String estado;
	
	/*Clear*/
	
	public void clear(){
		this.setId(null);
		this.setEstado(null);
		this.setNome(null);
		this.setSetor(null);
		this.setSigla(null);
	}
	
	/* Getters and Setters */

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}
}
