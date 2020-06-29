package br.gov.rj.mis.view;

import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import org.primefaces.event.RowEditEvent;

import br.gov.rj.mis.controller.entityBean.TecnicaEntityBeanInterface;
import br.gov.rj.mis.controller.entityBean.TipoDocumentalEntityBeanInterface;
import br.gov.rj.mis.model.Tecnica;
import br.gov.rj.mis.model.TipoDocumental;
import br.gov.rj.mis.util.EstadoRegistro;
import br.gov.rj.mis.util.Mensagem;

@ManagedBean(name="tecnicaManagedBean")
public class TecnicaManagedBean {
	@EJB(name = "tipoDocumentalEntityBean")
	private TipoDocumentalEntityBeanInterface tipoDocumentalEntityBean;
	
	@EJB(name = "tecnicaEntityBean")
	private TecnicaEntityBeanInterface tecnicaEntityBean;
	
	private Collection<TipoDocumental> tiposDoc;
	private Tecnica tecnica;
	private List<Tecnica> tecnicas;
	private List<Tecnica> tecnicaFiltrada;
	private Tecnica tecnicaSelecionada;
	
	@PostConstruct
	public void populaCampos(){
		tiposDoc = tipoDocumentalEntityBean.retrieveAll();
		tecnica = new Tecnica();
		tecnicas = tecnicaEntityBean.retrieveAll();
	}
	
	public void salvarTecnica(){
		tecnica.setEstado(EstadoRegistro.HABILITADO.toString());
		tecnicaEntityBean.salvarTecnica(tecnica);
		limparTecnica();
		tecnicas.clear();
		tecnicas = tecnicaEntityBean.retrieveAll();
		
		Mensagem.sucesso("tecnicaCadastrada");
	}
	
	public void excluiElementoTecnica(){
		tecnicas.remove(tecnicaSelecionada);
		tecnicaEntityBean.excluirTecnica(tecnicaSelecionada);
		Mensagem.sucesso("tecnicaExcluida");	
	}
	
	//listeners row editing
	public void onEdit(RowEditEvent event) {
		tecnicaSelecionada = (Tecnica) event.getObject();
		tecnicaEntityBean.editarTecnica(tecnicaSelecionada);
		tecnicaSelecionada.clear();
		tecnicas.clear();
		tecnicas = tecnicaEntityBean.retrieveAll();
		
		Mensagem.sucesso("tecnicaEditada");
	}
		
	public void onCancel(RowEditEvent event) {
		Mensagem.sucesso("edicaoCancelada");
	}
	
	public void limparTecnica(){
		tecnica.clear();
	}

	/*Getter and Setter*/
	public Collection<TipoDocumental> getTiposDoc() {
		return tiposDoc;
	}

	public void setTiposDoc(Collection<TipoDocumental> tiposDoc) {
		this.tiposDoc = tiposDoc;
	}

	public Tecnica getTecnica() {
		return tecnica;
	}

	public void setTecnica(Tecnica tecnica) {
		this.tecnica = tecnica;
	}

	public List<Tecnica> getTecnicas() {
		return tecnicas;
	}

	public void setTecnicas(List<Tecnica> tecnicas) {
		this.tecnicas = tecnicas;
	}

	public List<Tecnica> getTecnicaFiltrada() {
		return tecnicaFiltrada;
	}

	public void setTecnicaFiltrada(List<Tecnica> tecnicaFiltrada) {
		this.tecnicaFiltrada = tecnicaFiltrada;
	}

	public Tecnica getTecnicaSelecionada() {
		return tecnicaSelecionada;
	}

	public void setTecnicaSelecionada(Tecnica tecnicaSelecionada) {
		this.tecnicaSelecionada = tecnicaSelecionada;
	}
}
