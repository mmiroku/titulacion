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
import mx.upiicsa.titulacion.model.Alumno;

@Stateless(mappedName = "ejb/AlumnoService")
public class AlumnoService implements Serializable {

	private static final long serialVersionUID = -8510737783635751315L;
	
	@Inject
	private EntityManager entityManager;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(Alumno alumno) {
		entityManager.persist(alumno.getDireccion());
		entityManager.persist(alumno);
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<Alumno> findAllAlumno() throws TitulacionException {
		TypedQuery<Alumno> query = entityManager.createNamedQuery(
				"Alumno.findAll", Alumno.class);
		List<Alumno> alumnoList = new ArrayList<Alumno>();
		try {
			alumnoList = query.getResultList();
		} catch(NoResultException e) {
			
		}
		return alumnoList;
	}
}
