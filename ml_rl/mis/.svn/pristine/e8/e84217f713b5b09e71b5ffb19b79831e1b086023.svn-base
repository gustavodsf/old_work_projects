package br.gov.rj.mis.controller.entityBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.gov.rj.mis.model.ProgramaSerieAlbumProjeto;
import br.gov.rj.mis.util.EstadoRegistro;


@Local
@Stateless(name="programaSerieAlbumProjetoEntityBean")
public class ProgramaSerieAlbumProjetoEntityBean  implements Serializable,ProgramaSerieAlbumProjetoEntityBeanInterface{

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName="mis")
	EntityManager em;
	
	@Override
	public void salvarPSAP(ProgramaSerieAlbumProjeto psap) {
		em.persist(psap);
	}

	@Override
	public List<ProgramaSerieAlbumProjeto> retrieveAll() {
		Query query = em.createQuery("SELECT p FROM ProgramaSerieAlbumProjeto p WHERE p.estado != :estado ORDER BY p.nome");
		query.setParameter("estado", EstadoRegistro.EXCLUIDO.toString());
		
		List<ProgramaSerieAlbumProjeto> psaps = new ArrayList<ProgramaSerieAlbumProjeto>();
		List<?> result =	query.getResultList();
		for(Object obj: result){
			ProgramaSerieAlbumProjeto psap=  (ProgramaSerieAlbumProjeto) obj;
			psaps.add(psap);
		}
		return psaps;
	}

	@Override
	public void excluirTecnica(ProgramaSerieAlbumProjeto psap) {
		Query query = em.createQuery("UPDATE ProgramaSerieAlbumProjeto p SET p.estado = :estado WHERE p.id = :id");
		query.setParameter("id", psap.getId());
		query.setParameter("estado", EstadoRegistro.EXCLUIDO.toString());
		query.executeUpdate();
	}

	@Override
	public void editarTecnica(ProgramaSerieAlbumProjeto psap) {
		em.merge(psap);
	}
	
}
