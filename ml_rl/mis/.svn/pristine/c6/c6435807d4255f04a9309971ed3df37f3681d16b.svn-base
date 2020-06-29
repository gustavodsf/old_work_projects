package br.gov.rj.mis.view;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

import org.primefaces.event.RowEditEvent;

import br.gov.rj.mis.controller.entityBean.ObjetoEntityBeanInterface;
import br.gov.rj.mis.controller.entityBean.TipoDocumentalEntityBeanInterface;
import br.gov.rj.mis.model.Objeto;
import br.gov.rj.mis.model.TipoDocumental;
import br.gov.rj.mis.util.EstadoRegistro;
import br.gov.rj.mis.util.Mensagem;

@ManagedBean(name="objetoManagedBean")
public class ObjetoManagedBean {
	@EJB(name = "tipoDocumentalEntityBean")
	private TipoDocumentalEntityBeanInterface tipoDocumentalEntityBean;
	
	@EJB(name = "objetoEntityBean")
	private ObjetoEntityBeanInterface objetoEntityBean;
	
	private Collection<TipoDocumental> tiposDoc;
	private SelectItem[] tiposDocOpt;
	private Objeto objeto;
	private Collection<Objeto> objetos;
	private Collection<Objeto> objetosFiltrados;
	private Objeto objetoSelecionado;
	
	@PostConstruct
	public void populaCampos(){
		this.tiposDoc = tipoDocumentalEntityBean.retrieveAll();
		objeto = new Objeto();
		objetos = objetoEntityBean.retrieveAll();
		tiposDocOpt = incializaOptsTabela(tiposDoc.toArray());
	}
	

	public void salvarObjeto(){
		objeto.setEstado(EstadoRegistro.HABILITADO.name());
		objetoEntityBean.salvarObjeto(objeto);
		objeto.clear();
		objetos.clear();
		objetos.addAll(objetoEntityBean.retrieveAll());
		
		Mensagem.sucesso("objetoCadastrado");
	}
	
	public void excluirObjeto(){
		objetos.remove(objetoSelecionado);
		objetoEntityBean.excluirObjeto(objetoSelecionado);
		Mensagem.sucesso("funcaoExcluida");
	}
	
	public void onEdit(RowEditEvent event) {
		objetoSelecionado = (Objeto) event.getObject();
		objetoEntityBean.editarObjeto(objetoSelecionado);
		
		Mensagem.sucesso("objetoEditado");
    }
	
    public void onCancel(RowEditEvent event) {
    	Mensagem.sucesso("edicaoCancelada");
    }
	
	
	private SelectItem[] incializaOptsTabela(Object[] objects) {
		SelectItem[] options = new SelectItem[objects.length + 1];
		options[0] = new SelectItem("", "");
		
		for (int i = 1 ; i < options.length; i++) {
			TipoDocumental tipoDoc = (TipoDocumental)objects[i-1];
			options[i] = new SelectItem(tipoDoc.getNome(), tipoDoc.getNome());
		}
		
		return options;
	}
	
	/*Getter and Setter*/
	public Collection<TipoDocumental> getTiposDoc() {
		return tiposDoc;
	}

	public void setTiposDoc(Collection<TipoDocumental> tiposDoc) {
		this.tiposDoc = tiposDoc;
	}

	public Objeto getObjeto() {
		return objeto;
	}

	public void setObjeto(Objeto objeto) {
		this.objeto = objeto;
	}

	public Collection<Objeto> getObjetos() {
		return objetos;
	}

	public void setObjetos(Collection<Objeto> objetos) {
		this.objetos = objetos;
	}

	public Collection<Objeto> getObjetosFiltrados() {
		return objetosFiltrados;
	}

	public void setObjetosFiltrados(Collection<Objeto> objetosFiltrados) {
		this.objetosFiltrados = objetosFiltrados;
	}

	public Objeto getObjetoSelecionado() {
		return objetoSelecionado;
	}

	public void setObjetoSelecionado(Objeto objetoSelecionado) {
		this.objetoSelecionado = objetoSelecionado;
	}


	public SelectItem[] getTiposDocOpt() {
		return tiposDocOpt;
	}


	public void setTiposDocOpt(SelectItem[] tiposDocOpt) {
		this.tiposDocOpt = tiposDocOpt;
	}

	
	
	
}
