package br.gov.rj.mis.view;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;

import br.gov.rj.mis.controller.entityBean.FuncaoEntityBeanInterface;
import br.gov.rj.mis.model.Funcao;
import br.gov.rj.mis.util.EstadoRegistro;
import br.gov.rj.mis.util.Mensagem;

@ManagedBean(name="funcaoManagedBean")
@ViewScoped
public class FuncaoManagedBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@EJB(name="funcaoEntityBean")
	private FuncaoEntityBeanInterface funcaoEntityBean;
	
	private Funcao funcao; 
	private Funcao funcaoSelecionada;
	private Collection<Funcao> funcoes;
	private Collection<Funcao> funcoesFiltradas;
	

	@PostConstruct
	public void populaCampos(){
		funcao = new Funcao();
		funcoes= funcaoEntityBean.retrieveAll();
	}
	
	public void salvarFuncao(){
		
		Funcao funcaoConsultada = funcaoEntityBean.consultaFuncaoByNome(funcao.getNome());
		// ressuscita funcao que fora excluida caso a funcao inserida seja igual
		if (funcaoConsultada != null) {

			funcaoConsultada.setEstado(EstadoRegistro.HABILITADO.toString());
			funcaoEntityBean.editarFuncao(funcaoConsultada);

		} else {
			funcao.setEstado(EstadoRegistro.HABILITADO.toString());
			funcaoEntityBean.salvarFuncao(funcao);
		}
		
		funcao.clear();
		funcoes.clear();
		funcoes= funcaoEntityBean.retrieveAll();
		
		Mensagem.sucesso("funcaoCadastrado");
	}
	
	public void excluirFuncaoSelecionada(){
		funcoes.remove(funcaoSelecionada);
		funcaoEntityBean.excluirFuncao(funcaoSelecionada);
		Mensagem.sucesso("funcaoExcluida");
		
	}
	
	public void onEdit(RowEditEvent event) {
		funcaoSelecionada = (Funcao) event.getObject();
		
		Funcao funcaoConsultado = funcaoEntityBean.consultaFuncaoByNome(funcaoSelecionada.getNome());
		
		//edita funcao atual para outra que fora excluida
		if( funcaoConsultado != null){
			
			//salva o id da funcao a ser editada para futura exclusão
			long idSave = funcaoSelecionada.getId();
			
			//iguala o id da funcao a ser aditado, ao da funcao que fora excluida.
			funcaoSelecionada.setId(funcaoConsultado.getId());
			
			//exclui o funcao editado
			funcaoConsultado.setId(idSave);	
			funcaoEntityBean.excluirFuncao(funcaoConsultado);
		}
		
		funcaoEntityBean.editarFuncao(funcaoSelecionada);
		funcaoSelecionada.clear();
		funcoes.clear();
		funcoes = funcaoEntityBean.retrieveAll();
		
		Mensagem.sucesso("funcaoEditada");
    }
	
    public void onCancel(RowEditEvent event) {
    	Mensagem.sucesso("edicaoCancelada");
    }
	
	/*Getter and Setter*/
	public Funcao getFuncao() {
		return funcao;
	}

	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}

	public Collection<Funcao> getFuncoes() {
		return funcoes;
	}

	public void setFuncoes(Collection<Funcao> funcoes) {
		this.funcoes = funcoes;
	}

	public Funcao getFuncaoSelecionada() {
		return funcaoSelecionada;
	}

	public void setFuncaoSelecionada(Funcao funcaoSelecionada) {
		this.funcaoSelecionada = funcaoSelecionada;
	}
	
	
	public Collection<Funcao> getFuncoesFiltradas() {
		return funcoesFiltradas;
	}

	public void setFuncoesFiltradas(Collection<Funcao> funcoesFiltradas) {
		this.funcoesFiltradas = funcoesFiltradas;
	}
	
	
	
}
