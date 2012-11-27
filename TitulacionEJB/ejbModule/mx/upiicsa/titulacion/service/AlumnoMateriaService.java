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
import mx.upiicsa.titulacion.model.AlumnoMateria;

@Stateless(mappedName = "ejb/AlumnoMateriaService")
public class AlumnoMateriaService implements Serializable {
	
private static final long serialVersionUID = -8510737783635751315L;
	
	@Inject
	private EntityManager entityManager;
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<AlumnoMateria> findAllAlumnoMateria() throws TitulacionException {
		TypedQuery<AlumnoMateria> query = entityManager.createNamedQuery(
				"AlumnoMateria.findAll", AlumnoMateria.class);
		List<AlumnoMateria> alumnoMateriaList = new ArrayList<AlumnoMateria>();
		try {
			alumnoMateriaList = query.getResultList();
		} catch(NoResultException e) {
			
		}
		return alumnoMateriaList;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void update(AlumnoMateria alumnoMateria) {
		entityManager.merge(alumnoMateria);
	}
		
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<AlumnoMateria> findByFilter(AlumnoMateria filtro) throws TitulacionException {
		TypedQuery<AlumnoMateria> query = entityManager.createNamedQuery(
				"AlumnoMateria.findByFilter", AlumnoMateria.class);
									
		//if (filtro.getPerfil() != null){
		//	query.setParameter("idPerfil", filtro.getPerfil().getIdPerfil());
		//} else {
		//	query.setParameter("idPerfil", 0);
		//}
				
		//query.setParameter("nombre",filtro.getNombre());
		
		List<AlumnoMateria> alumnoMateriaList = new ArrayList<AlumnoMateria>();
		try {
			alumnoMateriaList = query.getResultList();
		} catch(NoResultException e) {
			
		}
		return alumnoMateriaList;
	}
}
