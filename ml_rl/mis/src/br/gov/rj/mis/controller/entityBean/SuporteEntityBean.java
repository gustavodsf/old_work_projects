package br.gov.rj.mis.controller.entityBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.gov.rj.mis.model.Suporte;
import br.gov.rj.mis.util.EstadoRegistro;

@Local
@Stateless(name = "suporteEntityBean")
public class SuporteEntityBean implements SuporteEntityBeanInterface, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "mis")
	EntityManager em;

	@Override
	public void salvarSuporte(Suporte suporte) {
		em.persist(suporte);
	}

	@Override
	public List<Suporte> retrieveAll() {
		Query query = em.createQuery("SELECT s FROM Suporte s WHERE s.estado != :estado ORDER BY s.nome");
		query.setParameter("estado", EstadoRegistro.EXCLUIDO.toString());
		
		List<Suporte> suportes = new ArrayList<Suporte>();
		List<?> result =	query.getResultList();
		for(Object obj: result){
			Suporte suporte =  (Suporte) obj;
			suportes.add(suporte);
		}
		return suportes;
	}

	@Override
	public void excluirSuporte(Suporte suporte) {
		Query query = em.createQuery("UPDATE Suporte s SET s.estado = :estado WHERE s.id = :id");
		query.setParameter("id", suporte.getId());
		query.setParameter("estado", EstadoRegistro.EXCLUIDO.toString());
		query.executeUpdate();
		
	}

	@Override
	public void editarSuporte(Suporte suporte) {
		em.merge(suporte);
	}

}
