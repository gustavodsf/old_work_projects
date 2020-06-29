package br.gov.rj.mis.controller.entityBean;

import java.util.List;

import javax.ejb.Local;

import br.gov.rj.mis.model.Locais;

@Local
public interface LocalEntityBeanInterface {
	public void salvarLocal(Locais local);
	public List<Locais> retrieveAll();
	public void editarLocal(Locais local);
	public void excluirLocal(Locais local);
	public Locais consultaLocalByNome(String nome);

}
