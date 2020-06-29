package br.gov.rj.mis.controller.entityBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.gov.rj.mis.model.Locais;
import br.gov.rj.mis.util.EstadoRegistro;

@Local
@Stateless(name = "localEntityBean")
public class LocalEntityBean implements LocalEntityBeanInterface, Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "mis")
	EntityManager em;

	@Override
	public void salvarLocal(Locais local) {
		em.persist(local);
	}


	public void editarLocal(Locais local) {
		em.merge(local);	
	}

	@Override
	public List<Locais> retrieveAll() {
		Query query = em.createQuery("SELECT l FROM Locais l WHERE l.estado != :estado ORDER BY l.nome");
		query.setParameter("estado", EstadoRegistro.EXCLUIDO.toString());
		
		List<Locais> locais = new ArrayList<Locais>();
		for (Object obj : query.getResultList()) {
			Locais local = (Locais) obj;
			locais.add(local);
		}
		return locais;
	}

	public Locais consultaLocalByNome(String nome) {

		Query query = em.createQuery("SELECT l FROM Locais l WHERE l.nome = :nome");
		query.setParameter("nome", nome);

		try {
			return (Locais) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public void excluirLocal(Locais local) {
		Query query = em.createQuery("UPDATE Locais l SET l.estado=:estado WHERE l.id=:id");
		query.setParameter("id", local.getId());
		query.setParameter("estado", EstadoRegistro.EXCLUIDO.toString());
		query.executeUpdate();
	}

}