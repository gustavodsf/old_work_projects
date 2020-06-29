package br.gov.rj.mis.controller.entityBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.gov.rj.mis.model.Objeto;
import br.gov.rj.mis.util.EstadoRegistro;

@Local
@Stateless(name="objetoEntityBean")
public class ObjetoEntityBean  implements ObjetoEntityBeanInterface,Serializable{

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="mis")
	EntityManager  em;
	
	@Override
	public void salvarObjeto(Objeto objeto) {
		em.persist(objeto);
	}

	@Override
	public Collection<Objeto> retrieveAll() {
		Query query = em.createQuery("SELECT o FROM Objeto o WHERE o.estado != :estado");
		query.setParameter("estado", EstadoRegistro.EXCLUIDO.name());
		Collection<Objeto> result = new ArrayList<Objeto>();
		for (Object obj : query.getResultList()) {
			Objeto objeto = (Objeto) obj;
			result.add(objeto);
		}
		return result;
	}

	@Override
	public void excluirObjeto(Objeto objeto) {
		Query query = em.createQuery("UPDATE Objeto o SET o.estado = :estado WHERE o.id = :id");
		query.setParameter("estado", EstadoRegistro.HABILITADO.toString());
		query.setParameter("id", objeto.getId());
		query.executeUpdate();
		
	}

	@Override
	public void editarObjeto(Objeto objeto) {
		em.merge(objeto);
	}
	
}
