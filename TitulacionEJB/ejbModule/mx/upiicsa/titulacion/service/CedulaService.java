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
import mx.upiicsa.titulacion.model.Cedula;

@Stateless(mappedName = "ejb/CedulaService")
public class CedulaService implements Serializable {
	
private static final long serialVersionUID = -8510737783635751315L;
	
	@Inject
	private EntityManager entityManager;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(Cedula cedula) {	
		entityManager.persist(cedula);
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<Cedula> findAllCedula() throws TitulacionException {
		TypedQuery<Cedula> query = entityManager.createNamedQuery(
				"Cedula.findAll", Cedula.class);
		List<Cedula> cedulaList = new ArrayList<Cedula>();
		try {
			cedulaList = query.getResultList();
		} catch(NoResultException e) {
			
		}
		return cedulaList;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void update(Cedula cedula) {		
		entityManager.merge(cedula);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(String IdCedula) throws TitulacionException {
		Cedula cedula = entityManager.find(Cedula.class, IdCedula);
		System.out.println("encontre cedula: " + cedula);
		if (cedula == null) {
			System.out.println("uchas fue error");
			throw new TitulacionException("El Cedula no existe.");
		}
		entityManager.remove(cedula);
		System.out.println("ps si lo elimine");
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<Cedula> findByFilter(Cedula filtro) throws TitulacionException {
		TypedQuery<Cedula> query = entityManager.createNamedQuery(
				"Cedula.findByFilter", Cedula.class);
		query.setParameter("cedula", filtro.getNumeroCedula());			
		query.setParameter("titulo", filtro.getTitulo());
		List<Cedula> cedulaList = new ArrayList<Cedula>();
		try {
			cedulaList = query.getResultList();
		} catch(NoResultException e) {
			
		}
		return cedulaList;
	}
}
