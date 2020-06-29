package br.gov.rj.mis.controller.entityBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.gov.rj.mis.model.Velocidade;
import br.gov.rj.mis.util.EstadoRegistro;

@Local
@Stateless(name="velocidadeEntityBean")
public class VelocidadeEntityBean implements VelocidadeEntityBeanInterface, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "mis")
	EntityManager em;
	
	@Override
	public void salvaVelocidade(Velocidade velocidade) {
		if(velocidade != null)
			em.persist(velocidade);
	}

	@Override
	public List<Velocidade> retrieveAll() {
		Query query = em.createQuery("SELECT v FROM Velocidade v WHERE v.estado != :estado ORDER BY v.nome");
		query.setParameter("estado", EstadoRegistro.EXCLUIDO.toString());
		
		List<Velocidade> velocidades = new ArrayList<Velocidade>();
		List<?> result =	query.getResultList();
		for(Object obj: result){
			Velocidade velocidade=  (Velocidade) obj;
			velocidades.add(velocidade);
		}
		return velocidades;
	}

	@Override
	public void excluirVelocidade(Velocidade velocidade) {
		Query query = em.createQuery("UPDATE Velocidade v SET v.estado = :estado WHERE v.id = :id");
		query.setParameter("id", velocidade.getId());
		query.setParameter("estado", EstadoRegistro.EXCLUIDO.toString());
		query.executeUpdate();
		
	}

	@Override
	public void editarVelocidade(Velocidade velocidade) {
		em.merge(velocidade);
	}
	

}
