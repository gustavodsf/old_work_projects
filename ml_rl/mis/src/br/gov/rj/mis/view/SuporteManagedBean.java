package br.gov.rj.mis.view;

import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import org.primefaces.event.RowEditEvent;

import br.gov.rj.mis.controller.entityBean.SuporteEntityBeanInterface;
import br.gov.rj.mis.controller.entityBean.TipoDocumentalEntityBeanInterface;
import br.gov.rj.mis.model.Suporte;
import br.gov.rj.mis.model.TipoDocumental;
import br.gov.rj.mis.util.EstadoRegistro;
import br.gov.rj.mis.util.Mensagem;

@ManagedBean(name = "suporteManagedBean")
public class SuporteManagedBean {
	
	@EJB(name = "suporteEntityBean")
	private SuporteEntityBeanInterface suporteEntityBean;
	
	@EJB(name = "tipoDocumentalEntityBean")
	private TipoDocumentalEntityBeanInterface tipoDocBean;
	
	private Collection<TipoDocumental> tiposDoc;
	private Suporte suporte;
	private List<Suporte> suportes;
	private List<Suporte> suporteFiltrado;
	private Suporte suporteSelecionado;
	
	@PostConstruct
	public void popularCampos(){
		tiposDoc = tipoDocBean.retrieveAll();
		this.suporte = new Suporte();
		suportes = suporteEntityBean.retrieveAll();
	}
	
	public void salvarSuporte(){
		
		suporte.setEstado(EstadoRegistro.HABILITADO.toString());
		suporteEntityBean.salvarSuporte(suporte);
		limparSuporte();
		suportes.clear();
		suportes = suporteEntityBean.retrieveAll();
		
		Mensagem.sucesso("suporteCadastrado");		
	}
	
	public void excluiElementoSuporte(){
		suportes.remove(suporteSelecionado);
		suporteEntityBean.excluirSuporte(suporteSelecionado);
		Mensagem.sucesso("suporteExcluido");	
	}
	
	//listeners row editing
	public void onEdit(RowEditEvent event) {
		suporteSelecionado = (Suporte) event.getObject();
		suporteEntityBean.editarSuporte(suporteSelecionado);
		suporteSelecionado.clear();
		suportes = suporteEntityBean.retrieveAll();
		
		Mensagem.sucesso("suporteEditado");
	}
		
	public void onCancel(RowEditEvent event) {
		Mensagem.sucesso("edicaoCancelada");
	}
	
	public void limparSuporte(){
		suportes.clear();
	}
		
	/*Getter and Setter*/
	public Collection<TipoDocumental> getTiposDoc() {
		return tiposDoc;
	}

	public void setTiposDoc(Collection<TipoDocumental> tiposDoc) {
		this.tiposDoc = tiposDoc;
	}

	public Suporte getSuporte() {
		return suporte;
	}

	public void setSuporte(Suporte suporte) {
		this.suporte = suporte;
	}

	public List<Suporte> getSuporteFiltrado() {
		return suporteFiltrado;
	}

	public void setSuporteFiltrado(List<Suporte> suporteFiltrado) {
		this.suporteFiltrado = suporteFiltrado;
	}

	public Suporte getSuporteSelecionado() {
		return suporteSelecionado;
	}

	public void setSuporteSelecionado(Suporte suporteSelecionado) {
		this.suporteSelecionado = suporteSelecionado;
	}

	public List<Suporte> getSuportes() {
		return suportes;
	}

	public void setSuportes(List<Suporte> suportes) {
		this.suportes = suportes;
	}
}
