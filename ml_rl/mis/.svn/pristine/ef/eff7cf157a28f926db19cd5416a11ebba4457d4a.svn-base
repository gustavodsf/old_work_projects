package br.gov.rj.mis.controller.entityBean;

import java.util.Collection;

import javax.ejb.Local;

import br.gov.rj.mis.model.Usuario;

@Local
public interface UsuarioEntityBeanInteface {
	public Collection<Usuario> retrieveAll();
	public void saveUsuario(Usuario usuario);
	public Usuario findUsuarioById(Long id);
	public Usuario findUsuarioByNomeUsuario(String nomeUsuario);
	public Usuario findUsuarioByEmail(String email);
}
