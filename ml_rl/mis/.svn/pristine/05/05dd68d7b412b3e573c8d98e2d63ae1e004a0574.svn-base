package br.gov.rj.mis.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Usuario implements Serializable {
	

	private static final long serialVersionUID = 1L;

	@SequenceGenerator(name="USUARIO_SEQUENCE_GENERATOR", sequenceName="USUARIO_SEQUENCE", initialValue=2, allocationSize=1)
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USUARIO_SEQUENCE_GENERATOR")
	private Long id;
	
	@Column(length=80)
	private String email;
	
	@Column(length=80)
	private String senha;

	@Column(length=9)
	private String cep;
	
	@Column(name="data_nascimento")
	private String dataNascimento;
	
	@Column(length=80)
	private String endereco;
	
	@Column(length=50)
	private String escolaridade;
	
	@Column(length=50)
	private String instituicao;
	
	@Column(length=30)
	private String municipio;
	
	@Column(name="nome_completo",length=80)
	private String nomeCompleto;
	
	@Column(length=30)
	private String pais;
	
	@Column(length=50)
	private String profissao;
	
	@ManyToOne
	private Estado estado;
	
	private int serie;
	
	private boolean confirmado;
	
	@ManyToOne
	private Cargo cargo;
	
	@ManyToOne
	private Setor setor;
	
	@OneToOne
	private Atribuicao atribuicao;
	
	/*Clear*/
	
	public Usuario() {
		super();
		this.atribuicao = new Atribuicao();;
	}
	
	
	public void clear(){
		this.setId(null);
		this.setEmail(null);
		this.setSenha(null);
		this.setDataNascimento(null);
		this.setEndereco(null);
		this.setEscolaridade(null);
		this.setInstituicao(null);
		this.setNomeCompleto(null);
		this.setPais(null);
		this.setProfissao(null);
		this.setEstado(null);
		this.setSerie(0);
		this.setConfirmado(false);
		this.setCargo(null);
		this.setAtribuicao(null);
		this.setSetor(null);
	}
	
	

	/* Getters and Setters */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profisao) {
		this.profissao = profisao;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public int getSerie() {
		return serie;
	}

	public void setSerie(int serie) {
		this.serie = serie;
	}

	public boolean isConfirmado() {
		return confirmado;
	}

	public void setConfirmado(boolean confirmado) {
		this.confirmado = confirmado;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Atribuicao getAtribuicao() {
		return atribuicao;
	}

	public void setAtribuicao(Atribuicao atribuicao) {
		this.atribuicao = atribuicao;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}
}
