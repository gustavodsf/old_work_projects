package br.gov.rj.mis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="programa_serie_album_projeto")
public class ProgramaSerieAlbumProjeto {
	@SequenceGenerator(name="PSAP_SEQUENCE_GENERATOR", sequenceName="PSAP_SEQUENCE", initialValue=1, allocationSize=1)
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PSAP_SEQUENCE_GENERATOR")
	private Long id;
	
	@ManyToOne
	private Setor setor;
	
	@Column(length=80)
	private String nome;
	
	@Column(name="estado_registro", length=20, nullable=false)
	private String estado;
	
	@Column(length=20)
	private String tipo;
	
	/*Clear*/
	public void clear(){
		this.setId(null);
		this.setEstado(null);
		this.setNome(null);
		this.setSetor(null);
		this.setTipo(null);
	}

	/*Getter and Setter*/
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
