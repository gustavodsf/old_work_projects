package br.gov.rj.mis.controller.entityBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.gov.rj.mis.model.Setor;

@Local
@Stateless(name="setorEntityBean")
public class SetorEntityBean implements SetorEntityBeanInterface, Serializable{

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="mis")
	EntityManager em;

	@Override
	public Setor findSetorByName(String nomeSistema) {
		Query query = em.createQuery("SELECT s FROM Setor s WHERE s.nomeSistema = :nome ORDER BY s.nome");
		query.setParameter("nome", nomeSistema);
		return (Setor)query.getSingleResult();
	}

	@Override
	public Collection<Setor> retrieveAllSetores() {
		Query query = em.createQuery("SELECT s FROM Setor s");
		Collection<Setor> setores = new ArrayList<Setor>();
		for (Object obj : query.getResultList()) {
			Setor setor = (Setor)obj;
			setores.add(setor);
		}
		return setores;
	}

	@Override
	public Setor findSetorById(Long id) {
		Query query = em.createQuery("SELECT s FROM Setor s WHERE s.id = :id");
		query.setParameter("id", id);
		return (Setor)query.getSingleResult();
	}
}
