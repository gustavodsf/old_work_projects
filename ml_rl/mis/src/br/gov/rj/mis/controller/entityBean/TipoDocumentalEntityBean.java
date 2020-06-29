package br.gov.rj.mis.controller.entityBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.gov.rj.mis.model.TipoDocumental;
import br.gov.rj.mis.util.EstadoRegistro;

@Local
@Stateless(name="tipoDocumentalEntityBean")
public class TipoDocumentalEntityBean implements Serializable,
		TipoDocumentalEntityBeanInterface {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="mis")
	EntityManager em;
	
	@Override
	public void salvarTipoDocumental(TipoDocumental tipoDocumental) {
		if(tipoDocumental != null)
			em.persist(tipoDocumental);
	}

	@Override
	public List<TipoDocumental> retrieveAll() {
		Query query = em.createQuery("SELECT td FROM TipoDocumental td  WHERE td.estado != :estado ORDER BY td.nome");
		query.setParameter("estado", EstadoRegistro.EXCLUIDO.toString());
		List<TipoDocumental> list = new ArrayList<TipoDocumental>();
		for (Object obj : query.getResultList()) {
			TipoDocumental tipoDoc = (TipoDocumental)obj;
			list.add(tipoDoc);
		}
		return list;
	}

	@Override
	public void excluirTipoDocumental(TipoDocumental tipoDocumental) {
		Query query = em.createQuery("UPDATE TipoDocumental td SET td.estado = :estado WHERE td.id = :id");
		query.setParameter("id", tipoDocumental.getId());
		query.setParameter("estado", EstadoRegistro.EXCLUIDO.toString());
		query.executeUpdate();
	}

	@Override
	public void editarTipoDocumental(TipoDocumental tipoDocumental) {
		em.merge(tipoDocumental);
	}

}
