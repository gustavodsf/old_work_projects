package br.gov.rj.mis.controller.entityBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.gov.rj.mis.model.Tecnica;
import br.gov.rj.mis.util.EstadoRegistro;

@Local
@Stateless(name="tecnicaEntityBean")
public class TecnicaEntityBean implements TecnicaEntityBeanInterface,Serializable{

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="mis")
	EntityManager em;

	public void salvarTecnica(Tecnica tecnica){
		em.persist(tecnica);
	}

	@Override
	public List<Tecnica> retrieveAll() {
		Query query = em.createQuery("SELECT t FROM Tecnica t WHERE t.estado != :estado ORDER BY t.nome");
		query.setParameter("estado", EstadoRegistro.EXCLUIDO.toString());
		
		List<Tecnica> tecnicas = new ArrayList<Tecnica>();
		List<?> result =	query.getResultList();
		for(Object obj: result){
			Tecnica tecnica=  (Tecnica) obj;
			tecnicas.add(tecnica);
		}
		return tecnicas;
	}

	@Override
	public void excluirTecnica(Tecnica tecnica) {
		Query query = em.createQuery("UPDATE Tecnica t SET t.estado = :estado WHERE t.id = :id");
		query.setParameter("id", tecnica.getId());
		query.setParameter("estado", EstadoRegistro.EXCLUIDO.toString());
		query.executeUpdate();
	}

	@Override
	public void editarTecnica(Tecnica tecnica) {
		em.merge(tecnica);
	}
}
