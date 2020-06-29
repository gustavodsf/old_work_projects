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

import br.gov.rj.mis.model.Idioma;
import br.gov.rj.mis.util.EstadoRegistro;

@Local
@Stateless(name="idiomaEntityBean")
public class IdiomaEntityBean implements IdiomaEntityBeanInterface, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="mis")
	EntityManager em;
	
	@Override
	public void salvarIdioma(Idioma idioma){
		em.persist(idioma);
	}
	
	@Override
	public void excluirIdioma(Idioma idioma) {
		Query query = em.createQuery("UPDATE Idioma i SET i.estado=:estado WHERE i.id=:id ");
		query.setParameter("id", idioma.getId());
		query.setParameter("estado", EstadoRegistro.EXCLUIDO.toString());
		query.executeUpdate();
	}
	
	@Override
	public void editarIdioma(Idioma idioma) {
		em.merge(idioma);
	}
	
	@Override
	public List<Idioma> retrieveAll() {
		Query query = em.createQuery("SELECT i FROM Idioma i WHERE i.estado != :estado ORDER BY i.nome");
		query.setParameter("estado", EstadoRegistro.EXCLUIDO.toString());
		
		List<Idioma> idiomas = new ArrayList<Idioma>();
		for(Object obj : query.getResultList()){
			Idioma idioma = (Idioma)obj;
			idiomas.add(idioma);
		}
		return idiomas;
	}
	
	public Idioma consultaIdiomaByNome(String nome) {

		Query query = em.createQuery("SELECT l FROM Idioma l WHERE l.nome = :nome");
		query.setParameter("nome", nome);

		try {
			return (Idioma) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}
