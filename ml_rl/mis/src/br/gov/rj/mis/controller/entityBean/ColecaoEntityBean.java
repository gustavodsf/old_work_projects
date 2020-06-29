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

import br.gov.rj.mis.model.Colecao;
import br.gov.rj.mis.util.EstadoRegistro;

@Local
@Stateless(name="colecaoEntityBean")
public class ColecaoEntityBean implements Serializable,ColecaoEntityBeanInterface{

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName="mis")
	EntityManager em;
	
	@Override
	public void salvarColecao(Colecao colecao) {
		em.persist(colecao);
	}

	@Override
	public Colecao findColecaoBySigla(String siglaColecao) {
		Query query = em.createQuery("SELECT c FROM Colecao c WHERE c.sigla = :sigla and c.estado != :estado");
		query.setParameter("estado", EstadoRegistro.EXCLUIDO.toString());
		query.setParameter("sigla", siglaColecao);
		
		try{
			return (Colecao)query.getSingleResult();
		}catch(NoResultException e){
			return null;
		}
		
	}
	
	public void editarColecao(Colecao colecao){
		em.merge(colecao);
	}

	@Override
	public Collection<Colecao> retrieveAll() {
		Query query = em.createQuery("SELECT c FROM Colecao c WHERE c.estado != :estado ORDER BY c.nome");
		query.setParameter("estado", EstadoRegistro.EXCLUIDO.toString());
		
		Collection<Colecao> colecoes = new ArrayList<Colecao>();
		Collection<?> result =	query.getResultList();
		for(Object obj: result){
			Colecao colecao =  (Colecao) obj;
			colecoes.add(colecao);
		}
		return colecoes;
	}

	@Override
	public void excluirColecao(Colecao colecao) {
		Query query = em.createQuery("UPDATE Colecao c SET c.estado = :estado WHERE c.id = :id");
		query.setParameter("id", colecao.getId());
		query.setParameter("estado", EstadoRegistro.EXCLUIDO.toString());
		query.executeUpdate();
	}
	
	
	
}
