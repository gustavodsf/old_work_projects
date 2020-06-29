package br.gov.rj.mis.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import org.primefaces.event.RowEditEvent;

import br.gov.rj.mis.controller.entityBean.SetorEntityBeanInterface;
import br.gov.rj.mis.controller.entityBean.TipoDocumentalEntityBeanInterface;
import br.gov.rj.mis.model.Setor;
import br.gov.rj.mis.model.TipoDocumental;
import br.gov.rj.mis.util.EstadoRegistro;
import br.gov.rj.mis.util.Mensagem;

@ManagedBean(name="tipoDocumentalManegedBean")
public class TipoDocumentalManagedBean {
	
	@EJB(name="tipoDocumentalEntityBean")
	private TipoDocumentalEntityBeanInterface tipoDocumentalEntityBean;
	
	@EJB(name="setorEntityBean")
	private SetorEntityBeanInterface setorEntity;
	
	private List<Setor> setores;
	private TipoDocumental tipoDoc;
	private List<TipoDocumental> tiposDoc;
	private List<TipoDocumental> tipoDocFiltrado;
	private TipoDocumental tipoDocSelecionado;
	
	@PostConstruct
	public void popularCampos(){
		this.setores = (List<Setor>) setorEntity.retrieveAllSetores();
		tipoDoc = new TipoDocumental();
		tiposDoc = tipoDocumentalEntityBean.retrieveAll();
	}
	
	public void salvarTipoDoc(){
		tipoDoc.setEstado(EstadoRegistro.HABILITADO.toString());
		tipoDocumentalEntityBean.salvarTipoDocumental(tipoDoc);
		limparTipoDoc();
		tiposDoc.clear();
		tiposDoc = tipoDocumentalEntityBean.retrieveAll();
		
		Mensagem.sucesso("tipoDocCadastrado");	
		
	}
	
	public void excluiElementoTipoDoc(){
		tipoDocumentalEntityBean.excluirTipoDocumental(tipoDocSelecionado);
		Mensagem.sucesso("tipDocExcluida");	
	}
	
	//listeners row editing
	public void onEdit(RowEditEvent event) {
		tipoDocSelecionado = (TipoDocumental) event.getObject();
		tipoDocumentalEntityBean.editarTipoDocumental(tipoDocSelecionado);
		tipoDocSelecionado.clear();
		tiposDoc.clear();
		tiposDoc = tipoDocumentalEntityBean.retrieveAll();
		
		Mensagem.sucesso("tipDocEditada");
	}
		
	public void onCancel(RowEditEvent event) {
		Mensagem.sucesso("edicaoCancelada");
	}
	
	public void limparTipoDoc() {
		tipoDoc.clear();
	}

	public TipoDocumental getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(TipoDocumental tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public List<TipoDocumental> getTiposDoc() {
		return tiposDoc;
	}

	public void setTiposDoc(List<TipoDocumental> tiposDoc) {
		this.tiposDoc = tiposDoc;
	}
	
	public void setSetores(List<Setor> setores) {
		this.setores = setores;
	}
	
	public List<Setor> getSetores(){
		return setores;
	}

	public List<TipoDocumental> getTipoDocFiltrado() {
		return tipoDocFiltrado;
	}

	public void setTipoDocFiltrado(List<TipoDocumental> tipoDocFiltrado) {
		this.tipoDocFiltrado = tipoDocFiltrado;
	}

	public TipoDocumental getTipoDocSelecionado() {
		return tipoDocSelecionado;
	}

	public void setTipoDocSelecionado(TipoDocumental tipoDocSelecionado) {
		this.tipoDocSelecionado = tipoDocSelecionado;
	}
	
	
}
