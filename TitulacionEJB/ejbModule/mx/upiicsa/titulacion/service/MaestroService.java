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
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void update(Maestro maestro) {		
		entityManager.merge(maestro);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(int IdMaestro) throws TitulacionException {
		Maestro maestro = entityManager.find(Maestro.class, IdMaestro);
		System.out.println("encontre alumno: " + maestro);
		if (maestro == null) {
			System.out.println("uchas fue error");
			throw new TitulacionException("El Alumno no existe.");
		}
		entityManager.remove(maestro);
		System.out.println("ps si lo elimine");
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<Maestro> findByFilter(Maestro filtro) throws TitulacionException {
		TypedQuery<Maestro> query = entityManager.createNamedQuery(
				"Maestro.findByFilter", Maestro.class);
		query.setParameter("nombre", filtro.getNombre());
		query.setParameter("abreviatura", filtro.getAbreviatura());
		if (filtro.getAcademia() != null) {
			query.setParameter("idAcademia", filtro.getAcademia().getIdAcademia());
		} else {
			query.setParameter("idAcademia", 0);
		}
		query.setParameter("titulo", filtro.getTitulo());
		List<Maestro> maestroList = new ArrayList<Maestro>();
		try {
			maestroList = query.getResultList();
		} catch(NoResultException e) {
			
		}
		return maestroList;
	}
}
