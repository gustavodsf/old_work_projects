package br.gov.rj.mis.controller.entityBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.gov.rj.mis.model.Usuario;

@Local
@Stateless(name="usuarioEntityBean")
public class UsuarioEntityBean implements UsuarioEntityBeanInteface,Serializable {
	
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName="mis")
	EntityManager em;

	@Override
	public void saveUsuario(Usuario usuario) {
		if(usuario != null){
			em.persist(usuario);
		}
	}

	@Override
	public Usuario findUsuarioById(Long id) {
		Query query = em.createQuery("SELECT usuario FROM Usuario usuario WHERE usuario.id=:id");
		query.setParameter("id", id);
		return (Usuario) query.getSingleResult();
	}

	@Override
	public Usuario findUsuarioByNomeUsuario(String nomeUsuario) {
		Query query = em.createQuery("SELECT usuario FROM Usuario usuario WHERE usuario.nomeUsuario=:nomeUsuario");
		query.setParameter("nomeUsuario", nomeUsuario);
		return (Usuario) query.getSingleResult();
	}

	@Override
	public Collection<Usuario> retrieveAll() {
		Query query = em.createQuery("SELECT u FROM Usuario u");
		Collection<Usuario> result = new ArrayList<Usuario>();
		for (Object obj : query.getResultList()) {
			Usuario user = (Usuario)obj;
			result.add(user);
		}
		return result;
	}

	@Override
	public Usuario findUsuarioByEmail(String email) {
		Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.email=:email");
		query.setParameter("email", email);
		return (Usuario) query.getSingleResult();
	}
	
}
