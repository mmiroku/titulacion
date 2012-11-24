package mx.upiicsa.titulacion.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import mx.upiicsa.titulacion.exceptions.TitulacionException;
import mx.upiicsa.titulacion.model.Acta;
import mx.upiicsa.titulacion.model.ActaExpediente;
import mx.upiicsa.titulacion.model.Alumno;
import mx.upiicsa.titulacion.model.Estatus;
import mx.upiicsa.titulacion.model.Expediente;

@Stateless(mappedName = "ejb/ExpedienteService")
public class ExpedienteService {

	@Inject
	private EntityManager entityManager;
	
	private static final String QUERY_GET_NO_IMPRESION = "SELECT MAX(ex.NumeroImpresion) FROM TblExpediente ex";
	
	private static final String QUERY_FIND_NO_ACTA_LIBRO = "SELECT MAX(ac.NumeroActa), MAX(ac.NumeroLibro) FROM TblAlumno al INNER JOIN TblActa ac ON al.Boleta = ac.Boleta WHERE al.IdCarrera = ?1";
	
	private Integer[] aIndustrial;
	private Integer[] cInformatica;
	private Integer[] iIndustrial;
	private Integer[] iInformatica;
	private Integer[] iTransportes;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(Expediente expediente, List<Alumno> pasantes) {
		expediente.setNumeroImpresion(obtenerNoImpresion());
		expediente.setEstatus(new Estatus(1));
		entityManager.persist(expediente);
		for (Alumno current:pasantes) {
			Integer[] noActaLibro = obtenerIdentificadores(current);
			incrementarNoActaLibro(noActaLibro);
			Acta acta = new Acta();
			acta.setAlumno(current);
			acta.setNumeroActa(noActaLibro[0]);
			acta.setNumeroLibro(noActaLibro[1]);
			entityManager.persist(acta);
			ActaExpediente actaExpediente = new ActaExpediente();
			actaExpediente.setActa(acta);
			actaExpediente.setExpediente(expediente);
			entityManager.persist(actaExpediente);
		}
	}

	private Long obtenerNoImpresion() {
		Query query = entityManager.createNativeQuery(QUERY_GET_NO_IMPRESION);
		Object noImpresion = query.getSingleResult();
		if (noImpresion != null) {
			return Long.valueOf(String.valueOf(noImpresion)) + 1;
		}
		return 1L;
	}
	
	private Integer[] obtenerIdentificadores(Alumno pasante) {
		Query query = entityManager.createNativeQuery(QUERY_FIND_NO_ACTA_LIBRO);
		query.setParameter(1, pasante.getCarrera().getIdCarrera());
		switch(pasante.getCarrera().getIdCarrera()) {
		case 1:
			if (aIndustrial == null) {
				aIndustrial = convertArrayToInteger((Object[]) query.getSingleResult());
			}
			return aIndustrial;
		case 2:
			if (cInformatica == null) {
				cInformatica = convertArrayToInteger((Object[]) query.getSingleResult());
			}
			return cInformatica;
		case 3:
			if (iIndustrial == null) {
				iIndustrial = convertArrayToInteger((Object[]) query.getSingleResult());
			}
			return iIndustrial;
		case 4:
			if (iInformatica == null) {
				iInformatica = convertArrayToInteger((Object[]) query.getSingleResult());
			}
			return iInformatica;
		case 5:
			if (iTransportes == null) {
				iTransportes = convertArrayToInteger((Object[]) query.getSingleResult());
			}
			return iTransportes;
		}
		return null;
	}
	
	private void incrementarNoActaLibro(Integer[] noActaLibro) {
		Integer noActa = noActaLibro[0];
		Integer noLibro = noActaLibro[1];
		if (noActa.compareTo(200) < 0) {
			noActaLibro[0] = ++noActa;
			noActaLibro[1] = noLibro;
		} else {
			noActaLibro[0] = 1;
			noActaLibro[1] = ++noLibro;
		}
	}
	
	private Integer[] convertArrayToInteger(Object[] inputArray) {
		Integer[] response = null;
		if (inputArray[0] == null && inputArray[1] == null) {
			response = new Integer[] {0, 1};
		} else {
			response = new Integer[] { (Integer) inputArray[0],
					(Integer) inputArray[1] };
		}
		return response;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<Expediente> findAllExpediente() throws TitulacionException {
		TypedQuery<Expediente> query = entityManager.createNamedQuery(
				"Expediente.findAll", Expediente.class);
		List<Expediente> expedienteList = new ArrayList<Expediente>();
		try {
			expedienteList = query.getResultList();
		} catch(NoResultException e) {
			
		}
		return expedienteList;
	}
}
