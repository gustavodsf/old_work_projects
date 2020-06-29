package br.gov.rj.mis.controller.entityBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.gov.rj.mis.model.Estado;

@Local
@Stateless(name="estadoEntityBean")
public class EstadoEntityBean implements Serializable,EstadoEntityBeanInterface {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(name="mis")
	EntityManager em;
	
	@Override
	public Collection<Estado> retriveAllEstados() {
		Query query = em.createQuery("SELECT estado FROM Estado estado ORDER BY estado.sigla");
		Collection<Estado> estados = new ArrayList<Estado>();
		for(Object obj:query.getResultList()){
			Estado estado =  (Estado) obj;
			estados.add(estado);
		}
		return estados;
	}

	@Override
	public Estado findEstavdoBySigla(String sigla) {
		Query query = em.createQuery("SELECT e FROM Estado e Where e.sigla=:s");
		query.setParameter("s", sigla);
		return (Estado)query.getSingleResult();
	}

}
