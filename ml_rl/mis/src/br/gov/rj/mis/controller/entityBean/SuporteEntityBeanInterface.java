package br.gov.rj.mis.controller.entityBean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;

import br.gov.rj.mis.model.Suporte;

@Local
public interface SuporteEntityBeanInterface extends Serializable {
	
	public void salvarSuporte (Suporte suporte);
	public List<Suporte> retrieveAll();
	public void excluirSuporte(Suporte suporte);
	public void editarSuporte(Suporte Suporte);
}
