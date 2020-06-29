package br.gov.rj.mis.controller.entityBean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.gov.rj.mis.model.Cargo;

@Local
@Stateless(name = "cargoEntityBean")
public class CargoEntityBean implements CargoEntityBeanInterface, Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "mis")
	EntityManager em;

	@Override
	public Cargo findCargoByid(Long id) {
		Query query = em
				.createQuery("SELECT cargo FROM Cargo cargo WHERE cargo.id=:id ORDER BY cargo.nomeExibido");
		query.setParameter("id", id);
		return (Cargo) query.getSingleResult();
	}

	@Override
	public ArrayList<Cargo> retrieveAllCargos() {
		Query query = em
				.createQuery("SELECT cargo FROM Cargo cargo ORDER BY cargo.nomeExibido");
		ArrayList<Cargo> cargos = new ArrayList<Cargo>();
		for (Object obj : query.getResultList()) {
			Cargo cargo = (Cargo) obj;
			cargos.add(cargo);
		}
		return cargos;
	}

}
