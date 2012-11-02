package mx.upiicsa.titulacion.persistence;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class PersistenceConfig {

	@PersistenceContext(unitName="TitulacionPU")
	private EntityManager entityManager;

	@Produces
	public EntityManager obtenerEntityManager() {
		return entityManager;
	}
}
