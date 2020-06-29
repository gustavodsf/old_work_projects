package br.gov.rj.mis.view;

import java.util.Collection;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.gov.rj.mis.controller.entityBean.CargoEntityBeanInterface;
import br.gov.rj.mis.controller.entityBean.EstadoEntityBeanInterface;
import br.gov.rj.mis.controller.entityBean.SetorEntityBeanInterface;
import br.gov.rj.mis.controller.entityBean.UsuarioEntityBeanInteface;
import br.gov.rj.mis.model.Cargo;
import br.gov.rj.mis.model.Estado;
import br.gov.rj.mis.model.Setor;
import br.gov.rj.mis.model.Usuario;
import br.gov.rj.mis.util.CriptografarSenha;
import br.gov.rj.mis.util.UtilImpl;

@ManagedBean(name ="usuarioManagedBean")
public class UsuarioManagedBean {
	

	@EJB(name="usuarioEntityBean")
	private UsuarioEntityBeanInteface usuarioEntityBean;
	
	@EJB(name="cargoEntityBean")
	private CargoEntityBeanInterface cargoEntityBean;
	
	@EJB(name="estadoEntityBean")
	private EstadoEntityBeanInterface estadoEmtityBean;
	
	@EJB(name="setorEntityBean")
	private SetorEntityBeanInterface setorEmtityBean;
	
	private Collection<Cargo> cargos;
	private Collection<Estado> estados;
	private Collection<Setor> setores;
	//private Collection<Atribuicao> atribuicoes;
	private Usuario usuario;
	private String senhaConfirmacao;
	
	@PostConstruct
	public void popularCampos(){
		cargos  = cargoEntityBean.retrieveAllCargos();
		estados = estadoEmtityBean.retriveAllEstados();
		setores = setorEmtityBean.retrieveAllSetores();
		//setAtribuicoes(new ArrayList<Atribuicao>());
		usuario = new Usuario();	
	}
	
	public void salvarUsuario(){
		
		usuario.setSenha(CriptografarSenha.crypMD5(usuario.getSenha()));
		usuarioEntityBean.saveUsuario(usuario);
		usuario.clear();
				
		FacesContext fc = FacesContext.getCurrentInstance();
		ResourceBundle messaBundle = UtilImpl.getMessageBundle();
		String mensagem = messaBundle.getString("sucesso")+":"+messaBundle.getString("usuarioCadastrado");
		fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,mensagem,mensagem));
	}
	
	/*Getter and Setter*/
	public Collection<Estado> getEstados() {
		return estados;
	}

	public void setEstados(Collection<Estado> estados) {
		this.estados = estados;
	}

	public Collection<Cargo> getCargos() {
		return cargos;
	}

	public void setCargos(Collection<Cargo> cargos) {
		this.cargos = cargos;
	}

	public Collection<Setor> getSetores() {
		return setores;
	}

	public void setSetores(Collection<Setor> setores) {
		this.setores = setores;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getSenhaConfirmacao() {
		return senhaConfirmacao;
	}

	public void setSenhaConfirmacao(String senhaConfirmacao) {
		this.senhaConfirmacao = senhaConfirmacao;
	}

//	public Collection<Atribuicao> getAtribuicoes() {
//		return atribuicoes;
//	}
//
//	public void setAtribuicoes(Collection<Atribuicao> atribuicoes) {
//		this.atribuicoes = atribuicoes;
//	}

}
