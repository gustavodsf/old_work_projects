package br.gov.rj.mis.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Atribuicao  implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@SequenceGenerator(name="ATRUICAO_SEQUENCE_GENERATOR", sequenceName="ATRUICAO_SEQUENCE", initialValue=1, allocationSize=1)
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ATRUICAO_SEQUENCE_GENERATOR")
	private Long id;
	
	@ManyToOne
	private Setor setor;
	
	@Column(name="usuario_id")
	private Long usuarioId;
	
	private boolean ler;
	private boolean escrever;
	private boolean deletar;
	private boolean confirmar;
	
	
	
	
	
	public Atribuicao() {
		super();
		this.ler = false;
		this.escrever = false;
		this.deletar = false;
		this.confirmar = false;
	}


	/*Clear*/
	public void clear(){
		this.setDeletar(false);
		this.setEscrever(false);
		this.setConfirmar(false);
		this.setId(null);
		this.setLer(false);
		this.setSetor(null);
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
	public boolean isLer() {
		return ler;
	}
	public void setLer(boolean ler) {
		this.ler = ler;
	}
	public boolean isEscrever() {
		return escrever;
	}
	public void setEscrever(boolean escrever) {
		this.escrever = escrever;
	}
	public boolean isDeletar() {
		return deletar;
	}
	public void setDeletar(boolean deletar) {
		this.deletar = deletar;
	}


	public boolean isConfirmar() {
		return confirmar;
	}


	public void setConfirmar(boolean confirmar) {
		this.confirmar = confirmar;
	}
	
}
