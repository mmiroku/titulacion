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
import mx.upiicsa.titulacion.model.AlumnoLinea;

@Stateless(mappedName = "ejb/AlumnoLineaService")
public class AlumnoLineaService implements Serializable {
	
private static final long serialVersionUID = -8510737783635751315L;
	
	@Inject
	private EntityManager entityManager;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(AlumnoLinea alumnoLinea) {	
		entityManager.persist(alumnoLinea);
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<AlumnoLinea> findAllAlumnoLinea() throws TitulacionException {
		TypedQuery<AlumnoLinea> query = entityManager.createNamedQuery(
				"AlumnoLinea.findAll", AlumnoLinea.class);
		List<AlumnoLinea> alumnoLineaList = new ArrayList<AlumnoLinea>();
		try {
			alumnoLineaList = query.getResultList();
		} catch(NoResultException e) {
			
		}
		return alumnoLineaList;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void update(AlumnoLinea alumnoLinea) {		
		entityManager.merge(alumnoLinea);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(int IdAlumnoLinea) throws TitulacionException {
		AlumnoLinea alumnoLinea = entityManager.find(AlumnoLinea.class, IdAlumnoLinea);
		System.out.println("encontre alumno: " + alumnoLinea);
		if (alumnoLinea == null) {
			System.out.println("uchas fue error");
			throw new TitulacionException("El Alumno no existe.");
		}
		entityManager.remove(alumnoLinea);
		System.out.println("ps si lo elimine");
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<AlumnoLinea> findByFilter(AlumnoLinea filtro) throws TitulacionException {
		
		TypedQuery<AlumnoLinea> query = entityManager.createNamedQuery(
				"AlumnoLinea.findByFilter", AlumnoLinea.class);
				
		if (filtro.getAlumno() != null) {
			query.setParameter("alumno", filtro.getAlumno().getBoleta());
		} else {
			query.setParameter("alumno", 0);
		}
		
		if (filtro.getLinea() != null) {
			query.setParameter("linea", filtro.getLinea().getLinea());
		} else {
			query.setParameter("linea", 0);
		}
		
		if (filtro.getProyecto() != null) {
			query.setParameter("proyecto", filtro.getProyecto().getIdProyecto());
		} else {
			query.setParameter("proyecto", 0);
		}
		
		List<AlumnoLinea> alumnoLineaList = new ArrayList<AlumnoLinea>();
		try {
			alumnoLineaList = query.getResultList();
		} catch(NoResultException e) {
			
		}
		return alumnoLineaList;
	}
}
