package br.gov.rj.mis.controller.entityBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.gov.rj.mis.model.Funcao;
import br.gov.rj.mis.util.EstadoRegistro;

@Local
@Stateless(name="funcaoEntityBean")
public class FuncaoEntityBean implements FuncaoEntityBeanInterface,Serializable{

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="mis")
	EntityManager em;
	
	@Override
	public void salvarFuncao(Funcao funcao) {
			em.persist(funcao);
	}

	@Override
	public Collection<Funcao> retrieveAll() {
		Query query = em.createQuery("SELECT f FROM Funcao f WHERE f.estado != :estado ORDER BY f.nome");
		query.setParameter("estado", EstadoRegistro.EXCLUIDO.toString());
		
		Collection<Funcao> result = new ArrayList<Funcao>();
		for (Object obj : query.getResultList()) {
			Funcao funcao = (Funcao)obj;
			result.add(funcao);
		}
		return result;
	}

	@Override
	public void editarFuncao(Funcao funcao) {
		em.merge(funcao);	
	}
	
	@Override
	public void excluirFuncao(Funcao funcao) {
		Query query = em.createQuery("UPDATE Funcao f SET f.estado = :estado WHERE f.id = :id");
		query.setParameter("id", funcao.getId());
		query.setParameter("estado", EstadoRegistro.EXCLUIDO.toString());
		query.executeUpdate();
		
	}

	@Override
	public Funcao findFuncaoById(Long id) {
		Query query = em.createQuery("SELECT f FROM Funcao f WHERE f.id = :id");
		query.setParameter("id", id);
		Funcao result = (Funcao)query.getSingleResult();
		return result;
	}
	
	public Funcao consultaFuncaoByNome(String nome) {

		Query query = em.createQuery("SELECT l FROM Funcao l WHERE l.nome = :nome");
		query.setParameter("nome", nome);

		try {
			return (Funcao) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}


