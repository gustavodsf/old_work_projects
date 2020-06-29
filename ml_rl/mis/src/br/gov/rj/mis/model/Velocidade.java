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

@Entity
public class Velocidade implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@SequenceGenerator(name="VELOCIDADE_SEQUENCE_GENERATOR", sequenceName="VELOCIDADE_SEQUENCE", initialValue=1, allocationSize=1)
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="VELOCIDADE_SEQUENCE_GENERATOR")
	private Long id;

	@Column(length=80, nullable=false)
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "id_tipo_doc")
	private TipoDocumental tipoDocumental;
	
	@Column(name="estado_registro", length=20, nullable=false)
	private String estado;
	
	/*Clear*/
	
	public void clear(){
		this.setId(null);
		this.setEstado(null);
		this.setNome(null);
		this.setTipoDocumental(null);
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

	public TipoDocumental getTipoDocumental() {
		return tipoDocumental;
	}

	public void setTipoDocumental(TipoDocumental tipoDocumental) {
		this.tipoDocumental = tipoDocumental;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
