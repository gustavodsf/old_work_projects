package br.gov.rj.mis.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;

import br.gov.rj.mis.controller.entityBean.IdiomaEntityBeanInterface;
import br.gov.rj.mis.model.Idioma;
import br.gov.rj.mis.util.EstadoRegistro;
import br.gov.rj.mis.util.Mensagem;

@ManagedBean(name="idiomaManagedBean")
@ViewScoped
public class IdiomaManagedBean {
	
	private Idioma idioma;	
	private List<Idioma> idiomas;
	private List<Idioma> idiomaFiltrado;
	private Idioma idiomaSelecionado;
	
	
	@EJB(name="idiomaEntityBean")
	IdiomaEntityBeanInterface idiomaEntityBean;
	
	@PostConstruct
	public void populaCampos(){
		idioma = new Idioma();
		idiomas = idiomaEntityBean.retrieveAll();
	}
	
	
	public void salvarIdioma(){
		Idioma idiomaConsultado = idiomaEntityBean.consultaIdiomaByNome(idioma.getNome());
		// ressuscita idioma que fora excluido caso o idioma inserido seja igual
		if (idiomaConsultado != null) {

			idiomaConsultado.setEstado(EstadoRegistro.HABILITADO.toString());
			idiomaEntityBean.editarIdioma(idiomaConsultado);

		} else {
			idioma.setEstado(EstadoRegistro.HABILITADO.toString());
			idiomaEntityBean.salvarIdioma(idioma);
		}
		limparIdioma();
		idiomas.clear();
		idiomas = idiomaEntityBean.retrieveAll();
		
		Mensagem.sucesso("idiomaCadastrado");
	}
	
	public void excluiElementoIdioma() {
		idiomas.remove(idiomaSelecionado);
		idiomaEntityBean.excluirIdioma(idiomaSelecionado);
		Mensagem.sucesso("idiomaExcluido");
	}
	
	//listeners row editing
	public void onEdit(RowEditEvent event) {
		idiomaSelecionado = (Idioma) event.getObject();
		
		Idioma idiomaConsultado = idiomaEntityBean.consultaIdiomaByNome(idiomaSelecionado.getNome());
		
		//edita idioma atual para outro que fora excluido
		if( idiomaConsultado != null){
			
			//salva o id do idioma a ser editado para futura exclusão
			long idSave = idiomaSelecionado.getId();
			
			//iguala os id do idioma a ser aditado, ao idioma que fora excluido.
			idiomaSelecionado.setId(idiomaConsultado.getId());
			
			//exclui o idioma editado
			idiomaConsultado.setId(idSave);	
			idiomaEntityBean.excluirIdioma(idiomaConsultado);
		}
		
		
		idiomaEntityBean.editarIdioma(idiomaSelecionado);
		idiomaSelecionado.clear();
		idiomas.clear();
		idiomas = idiomaEntityBean.retrieveAll();
		
	    Mensagem.sucesso("idiomaEditado");
	}
		
	public void onCancel(RowEditEvent event) {
		Mensagem.sucesso("edicaoCancelada");
	}
	
	public void limparIdioma(){
		idioma.clear();
	}
	

	/*Getter and Setter*/
	public Idioma getIdioma() {
		return idioma;
	}
	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}


	public List<Idioma> getIdiomas() {
		return idiomas;
	}
	public void setIdiomas(List<Idioma> idiomas) {
		this.idiomas = idiomas;
	}


	public List<Idioma> getIdiomaFiltrado() {
		return idiomaFiltrado;
	}
	public void setIdiomaFiltrado(List<Idioma> idiomaFiltrado) {
		this.idiomaFiltrado = idiomaFiltrado;
	}


	public Idioma getIdiomaSelecionado() {
		return idiomaSelecionado;
	}
	public void setIdiomaSelecionado(Idioma idiomaSelecionado) {
		this.idiomaSelecionado = idiomaSelecionado;
	}
}
