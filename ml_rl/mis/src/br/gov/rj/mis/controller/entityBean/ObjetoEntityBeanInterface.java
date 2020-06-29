package br.gov.rj.mis.controller.entityBean;

import java.util.Collection;

import javax.ejb.Local;

import br.gov.rj.mis.model.Objeto;

@Local
public interface ObjetoEntityBeanInterface {
	public void salvarObjeto(Objeto objeto);
	public Collection<Objeto> retrieveAll();
	public void excluirObjeto(Objeto objeto);
	public void editarObjeto(Objeto objeto);
}
