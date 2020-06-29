package br.gov.rj.mis.controller.entityBean;

import java.util.List;

import javax.ejb.Local;

import br.gov.rj.mis.model.Idioma;

@Local
public interface IdiomaEntityBeanInterface {
	public List<Idioma> retrieveAll();
	public void salvarIdioma(Idioma idioma);
	public void excluirIdioma(Idioma idioma);
	public void editarIdioma(Idioma idioma);
	public Idioma consultaIdiomaByNome(String nome);
}
