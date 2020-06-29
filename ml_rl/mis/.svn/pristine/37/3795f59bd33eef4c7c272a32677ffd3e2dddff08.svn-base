package br.gov.rj.mis.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


@Entity
public class Colecao implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@SequenceGenerator(name="COLECAO_SEQUENCE_GENERATOR", sequenceName="COLECAO_SEQUENCE", initialValue=1, allocationSize=1)
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COLECAO_SEQUENCE_GENERATOR")
	private Long id;
	
	@Column(length=45)
	private String nome;
	
	@Column(length=4)
	private String sigla;
	
	@Column(name="forma_aquisicao",length=30)
	private String formaAquisicao;
	
	private String procedencia;
	
	@Column(name="data_aquisicao", length=10)
	private String dataAquisicao;
	
	@Column(name="estado_registro", length=20, nullable=false)
	private String estado;
	
	/*Clear*/
	public void clear(){
		this.setEstado(null);
		this.setDataAquisicao(null);
		this.setFormaAquisicao(null);
		this.setId(null);
		this.setNome(null);
		this.setProcedencia(null);
		this.setSigla(null);
	}
	
	public void copy(Colecao c){
		this.setEstado(c.getEstado());
		this.setDataAquisicao(c.getDataAquisicao());
		this.setFormaAquisicao(c.getFormaAquisicao());
		this.setId(c.getId());
		this.setNome(c.getNome());
		this.setProcedencia(c.getProcedencia());
		this.setSigla(c.getSigla());
	}
	
	public Colecao clone(){
		Colecao c = new Colecao();
		c.setEstado(this.getEstado());
		c.setDataAquisicao(this.getDataAquisicao());
		c.setFormaAquisicao(this.getFormaAquisicao());
		c.setId(this.getId());
		c.setNome(this.getNome());
		c.setProcedencia(this.getProcedencia());
		c.setSigla(this.getSigla());
		return c;
	}
	
	public void merge(Colecao tela){
		this.setDataAquisicao(tela.getDataAquisicao());
		this.setFormaAquisicao(tela.getFormaAquisicao());
		this.setNome(tela.getNome());
		this.setProcedencia(tela.getProcedencia());
		this.setSigla(tela.getSigla());
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

	public String getFormaAquisicao() {
		return formaAquisicao;
	}

	public void setFormaAquisicao(String formaAquisicao) {
		this.formaAquisicao = formaAquisicao;
	}

	public String getProcedencia() {
		return procedencia;
	}

	public void setProcedencia(String procedencia) {
		this.procedencia = procedencia;
	}

	public String getDataAquisicao() {
		return dataAquisicao;
	}

	public void setDataAquisicao(String dataAquisicao) {
		this.dataAquisicao = dataAquisicao;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
}
