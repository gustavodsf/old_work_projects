package br.gov.rj.mis.view;

import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import org.primefaces.event.RowEditEvent;

import br.gov.rj.mis.controller.entityBean.ProgramaSerieAlbumProjetoEntityBeanInterface;
import br.gov.rj.mis.controller.entityBean.SetorEntityBeanInterface;
import br.gov.rj.mis.model.ProgramaSerieAlbumProjeto;
import br.gov.rj.mis.model.Setor;
import br.gov.rj.mis.util.EstadoRegistro;
import br.gov.rj.mis.util.Mensagem;


@ManagedBean(name="psapManagedBean")
public class ProgramaSerieAlbumProjetoManagedBean {
	@EJB(name = "setorEntityBean")
	private SetorEntityBeanInterface setorEntityBean;
	
	@EJB(name = "programaAlbumSerieProjetoEntityBean")
	private ProgramaSerieAlbumProjetoEntityBeanInterface programaSerieAlbumProjetoEntityBean;
	
	private Collection<Setor> setores;
	private ProgramaSerieAlbumProjeto psap;
	private List<ProgramaSerieAlbumProjeto> psaps;
	private List<ProgramaSerieAlbumProjeto> psapsFiltrado;
	private ProgramaSerieAlbumProjeto psapSelecionado;
	
	
	@PostConstruct
	public void populaCampos(){
		setores = setorEntityBean.retrieveAllSetores();
		psap = new ProgramaSerieAlbumProjeto();
		psaps = programaSerieAlbumProjetoEntityBean.retrieveAll();
	}
	
	public void salvarPSAP(){
		psap.setEstado(EstadoRegistro.HABILITADO.toString());
		programaSerieAlbumProjetoEntityBean.salvarPSAP(psap);
		limparPSAP();
		psaps.clear();
		psaps = programaSerieAlbumProjetoEntityBean.retrieveAll();
		
		Mensagem.sucesso("psapCadastrado");
	}
	
	public void excluiElementoPSAP(){
		psaps.remove(psapSelecionado);
		programaSerieAlbumProjetoEntityBean.excluirTecnica(psapSelecionado);
		Mensagem.sucesso("psapExcluida");	
	}
	
	//listeners row editing
	public void onEdit(RowEditEvent event) {
		psapSelecionado = (ProgramaSerieAlbumProjeto) event.getObject();
		programaSerieAlbumProjetoEntityBean.editarTecnica(psapSelecionado);
		psapSelecionado.clear();
		psaps.clear();
		psaps = programaSerieAlbumProjetoEntityBean.retrieveAll();
		
		Mensagem.sucesso("psapEditada");
	}
		
	public void onCancel(RowEditEvent event) {
		Mensagem.sucesso("edicaoCancelada");
	}
	
	public void limparPSAP(){
		psap.clear();
	}

	
	/*Getter and Setter*/
	public Collection<Setor> getSetores() {
		return setores;
	}

	public void setSetores(Collection<Setor> setor) {
		this.setores = setor;
	}

	public ProgramaSerieAlbumProjeto getPsap() {
		return psap;
	}

	public void setPsap(ProgramaSerieAlbumProjeto psap) {
		this.psap = psap;
	}

	public List<ProgramaSerieAlbumProjeto> getPsaps() {
		return psaps;
	}

	public void setPsaps(List<ProgramaSerieAlbumProjeto> psaps) {
		this.psaps = psaps;
	}

	public List<ProgramaSerieAlbumProjeto> getPsapsFiltrado() {
		return psapsFiltrado;
	}

	public void setPsapsFiltrado(List<ProgramaSerieAlbumProjeto> psapsFiltrado) {
		this.psapsFiltrado = psapsFiltrado;
	}

	public ProgramaSerieAlbumProjeto getPsapSelecionado() {
		return psapSelecionado;
	}

	public void setPsapSelecionado(ProgramaSerieAlbumProjeto psapSelecionado) {
		this.psapSelecionado = psapSelecionado;
	}
}
