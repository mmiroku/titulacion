package mx.upiicsa.titulacion.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import mx.upiicsa.titulacion.exceptions.TitulacionException;
import mx.upiicsa.titulacion.model.Maestro;

@Stateless(mappedName = "ejb/MaestroService")
public class MaestroService implements Serializable {
	
private static final long serialVersionUID = -8510737783635751315L;
	
	@Inject
	private EntityManager entityManager;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(Maestro maestro) {	
		entityManager.persist(maestro);
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<Maestro> findAllMaestro() throws TitulacionException {
		TypedQuery<Maestro> query = entityManager.createNamedQuery(
				"Maestro.findAll", Maestro.class);
		List<Maestro> maestroList = new ArrayList<Maestro>();
		try {
			maestroList = query.getResultList();
		} catch(NoResultException e) {
			
		}
		return maestroList;
	}
}
