package br.gov.rj.mis.controller.entityBean;

import java.util.Collection;

import javax.ejb.Local;

import br.gov.rj.mis.model.Funcao;

@Local
public interface FuncaoEntityBeanInterface {
	public Collection<Funcao> retrieveAll(); 	 
	public void salvarFuncao(Funcao funcao);
	public void editarFuncao(Funcao funcao);
	public void excluirFuncao(Funcao funcao);
	public Funcao findFuncaoById(Long id);
	public Funcao consultaFuncaoByNome(String nome);
}
