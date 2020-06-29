package br.gov.rj.mis.view;

import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import org.primefaces.event.RowEditEvent;

import br.gov.rj.mis.controller.entityBean.TipoDocumentalEntityBeanInterface;
import br.gov.rj.mis.controller.entityBean.VelocidadeEntityBeanInterface;
import br.gov.rj.mis.model.TipoDocumental;
import br.gov.rj.mis.model.Velocidade;
import br.gov.rj.mis.util.EstadoRegistro;
import br.gov.rj.mis.util.Mensagem;

@ManagedBean(name = "velocidadeManagedBean")
public class VelocidadeManagedBean {
	
	@EJB(name = "tipoDocumentalEntityBean")
	private TipoDocumentalEntityBeanInterface tipoDocumentalEntityBean;
	
	@EJB(name = "velocidadeEntityBean")
	private VelocidadeEntityBeanInterface velocidadeEntityBean;
	
	private Collection<TipoDocumental> tiposDoc;
	private Velocidade velocidade;
	private List<Velocidade> velocidades;
	private List<Velocidade> velocidadeFiltrada;
	private Velocidade velocidadeSelecionada;
	
	@PostConstruct
	public void populaCampos(){
		this.tiposDoc = tipoDocumentalEntityBean.retrieveAll();
		this.velocidade = new Velocidade();
		velocidades = velocidadeEntityBean.retrieveAll();
	}
	
	public void salvarVelocidade(){
		velocidade.setEstado(EstadoRegistro.HABILITADO.toString());
		velocidadeEntityBean.salvaVelocidade(this.velocidade);
		velocidade.clear();
		velocidades = velocidadeEntityBean.retrieveAll();
		
		Mensagem.sucesso("velocidadeCadastrada");
	}
	
	public void excluiElementoVelocidade(){
		velocidades.remove(velocidadeSelecionada);
		velocidadeEntityBean.excluirVelocidade(velocidadeSelecionada);
		Mensagem.sucesso("velocidadeExcluida");	
	}
	
	//listeners row editing
	public void onEdit(RowEditEvent event) {
		velocidadeSelecionada = (Velocidade) event.getObject();
		velocidadeEntityBean.editarVelocidade(velocidadeSelecionada);
		velocidadeSelecionada.clear();
		velocidades.clear();
		velocidades = velocidadeEntityBean.retrieveAll();
		
		Mensagem.sucesso("velocidadeEditada");
	}
		
	public void onCancel(RowEditEvent event) {
		Mensagem.sucesso("edicaoCancelada");
	}
	
	public void limparTecnica(){
		velocidade.clear();
	}

	/*Getter and Setter*/
	public Collection<TipoDocumental> getTiposDoc() {
		return tiposDoc;
	}

	public void setTiposDoc(Collection<TipoDocumental> tiposDoc) {
		this.tiposDoc = tiposDoc;
	}

	public Velocidade getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(Velocidade velocidade) {
		this.velocidade = velocidade;
	}

	public List<Velocidade> getVelocidades() {
		return velocidades;
	}

	public void setVelocidades(List<Velocidade> velocidades) {
		this.velocidades = velocidades;
	}

	public List<Velocidade> getVelocidadeFiltrada() {
		return velocidadeFiltrada;
	}

	public void setVelocidadeFiltrada(List<Velocidade> velocidadeFiltrada) {
		this.velocidadeFiltrada = velocidadeFiltrada;
	}

	public Velocidade getVelocidadeSelecionada() {
		return velocidadeSelecionada;
	}

	public void setVelocidadeSelecionada(Velocidade velocidadeSelecionada) {
		this.velocidadeSelecionada = velocidadeSelecionada;
	}
}
