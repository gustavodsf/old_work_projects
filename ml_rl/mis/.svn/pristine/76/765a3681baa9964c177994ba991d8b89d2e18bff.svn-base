package br.gov.rj.mis.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import br.gov.rj.mis.controller.entityBean.ColecaoEntityBeanInterface;
import br.gov.rj.mis.model.Colecao;
import br.gov.rj.mis.util.EstadoRegistro;
import br.gov.rj.mis.util.Mensagem;

@ManagedBean(name="colecaoManagedBean")
@SessionScoped
public class ColecaoManagedBean {
	
	private String nomeSetor;
	private Colecao colecao;
	private Collection<Colecao> colecoes;
	private Colecao colecaoSelecionada;
	private List<Colecao> filteredColecao;


	@EJB(name="colecaoEntityBean")
	private ColecaoEntityBeanInterface colecaoEntityBean;
	
	private Date dataAquisicao;
	
	@PostConstruct
	public void populaCampos(){
		colecao = new Colecao();
		colecoes = colecaoEntityBean.retrieveAll();
	}
	
	public void salvarColecao(){
		
		if(dataAquisicao != null){
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");		
			this.colecao.setDataAquisicao(format.format(dataAquisicao));
		}
		
		if(colecaoSelecionada != null && colecaoSelecionada.getEstado() != null){
			if(!colecaoSelecionada.getSigla().equals(colecao.getSigla())){
				if(colecaoEntityBean.findColecaoBySigla(colecao.getSigla()) != null){
					Mensagem.erro("siglaCadastrada");
					setDataAquisicao(null);
					limparColecao();
					return;
				}
			}
			colecaoSelecionada.merge(colecao);
			colecaoEntityBean.editarColecao(colecaoSelecionada);
			colecoes.clear();
			
		}else{
			if(colecaoEntityBean.findColecaoBySigla(colecao.getSigla()) != null){
				Mensagem.erro("siglaCadastrada");
				setDataAquisicao(null);
				limparColecao();
				return;
			}
			colecao.setEstado(EstadoRegistro.HABILITADO.toString());
			colecaoEntityBean.salvarColecao(colecao);
		}
		
		colecoes = colecaoEntityBean.retrieveAll();
		this.limparColecao();
		setDataAquisicao(null);
		colecao = new Colecao();
		
		if(colecaoSelecionada != null){
			Mensagem.sucesso("colecaoAlterada");
		}
		else{
			Mensagem.sucesso("colecaoCadastrada");
		}
	}
	
	public void excluiElementoColecao(){
		colecoes.remove(colecaoSelecionada);
		colecaoEntityBean.excluirColecao(colecaoSelecionada);
		Mensagem.sucesso("colecaoExluida");
		
	}
	
	public void limparColecao(){
		colecao.clear();
	}
	
	
	public void populaColcecaoPanel(){
		SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
		colecao = colecaoEntityBean.findColecaoBySigla(colecaoSelecionada.getSigla());
		try {
			if(colecao.getDataAquisicao()!=null){
				dataAquisicao = formater.parse(colecao.getDataAquisicao());
			}else{
				dataAquisicao = null;
			}
		} catch (ParseException e) {
			Mensagem.erro("dataInvalida");
		}
	}
	
	/*Getter and Setter*/
	public Colecao getColecao() {
		return colecao;
	}

	public void setColecao(Colecao colecao) {
		this.colecao = colecao;
	}

	public String getNomeSetor() {
		return nomeSetor;
	}

	public void setNomeSetor(String nomeSetor) {
		this.nomeSetor = nomeSetor;
	}

	public Date getDataAquisicao() {
		return dataAquisicao;
	}

	public void setDataAquisicao(Date dataAquisicao) {
		this.dataAquisicao = dataAquisicao;
	}

	public Collection<Colecao> getColecoes() {
		return colecoes;
	}
	
	public void setColecoes(Collection<Colecao> colecoes) {
		this.colecoes = colecoes;
	}
	
	public List<Colecao> getFilteredColecao() {
		return filteredColecao;
	}

	public void setFilteredColecao(List<Colecao> filteredColecao) {
		this.filteredColecao = filteredColecao;
	}

	public Colecao getColecaoSelecionada() {
		return colecaoSelecionada;
	}


	public void setColecaoSelecionada(Colecao colecaoSelecionada) {
		this.colecaoSelecionada = colecaoSelecionada;
	}
}
