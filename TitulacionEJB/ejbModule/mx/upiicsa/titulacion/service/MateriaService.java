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

import mx.upiicsa.titulacion.common.enums.Semestre;
import mx.upiicsa.titulacion.exceptions.TitulacionException;
import mx.upiicsa.titulacion.model.Materia;

@Stateless(mappedName = "ejb/MateriaService")

public class MateriaService implements Serializable{
private static final long serialVersionUID = -8510737783635751315L;
	
	@Inject
	private EntityManager entityManager;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(Materia materia) {	
		entityManager.persist(materia);
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<Materia> findAllMateria() throws TitulacionException {
		TypedQuery<Materia> query = entityManager.createNamedQuery(
				"Materia.findAll", Materia.class);
		List<Materia> materiaList = new ArrayList<Materia>();
		try {
			materiaList = query.getResultList();
		} catch(NoResultException e) {
			
		}
		return materiaList;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void update(Materia materia) {		
		entityManager.merge(materia);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(String IdMateria) throws TitulacionException {
		Materia materia = entityManager.find(Materia.class, IdMateria);
		System.out.println("encontre alumno: " + materia);
		if (materia == null) {
			System.out.println("uchas fue error");
			throw new TitulacionException("El Alumno no existe.");
		}
		entityManager.remove(materia);
		System.out.println("ps si lo elimine");
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<Materia> findByFilter(Materia filtro) throws TitulacionException {
		TypedQuery<Materia> query = entityManager.createNamedQuery(
				"Materia.findByFilter", Materia.class);
		query.setParameter("materia", filtro.getNombre());
		query.setParameter("semestre", (Semestre) filtro.getSemestre());
		if (filtro.getLinea() != null) {
			query.setParameter("idLinea",filtro.getLinea().getLinea());
			} else {
			query.setParameter("idLinea", 0);
		}		
		if (filtro.getAcademia() != null) {
			query.setParameter("idAcademia", filtro.getAcademia().getIdAcademia());
		} else {
			query.setParameter("idAcademia", 0);
		}
		List<Materia> materiaList = new ArrayList<Materia>();
		try {
			materiaList = query.getResultList();
		} catch(NoResultException e) {
			
		}
		return materiaList;
	}
}
