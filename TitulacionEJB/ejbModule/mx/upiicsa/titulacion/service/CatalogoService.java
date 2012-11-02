package mx.upiicsa.titulacion.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import mx.upiicsa.titulacion.exceptions.TitulacionException;
import mx.upiicsa.titulacion.model.Carrera;
import mx.upiicsa.titulacion.model.Sexo;

@Stateless(mappedName = "ejb/CatalogoService")
public class CatalogoService implements Serializable {

	private static final long serialVersionUID = 1927696093799970047L;

	@Inject
	private EntityManager entityManager;
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<Sexo> findAllSexo() throws TitulacionException {
		TypedQuery<Sexo> query = entityManager.createNamedQuery(
				"Sexo.findAll", Sexo.class);
		List<Sexo> sexoList;
		try {
			sexoList = query.getResultList();
		} catch(NoResultException e) {
			throw new TitulacionException("No existen registros en el catálogo Sexo.");
		}
		return sexoList;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<Carrera> findAllCarrera() throws TitulacionException {
		TypedQuery<Carrera> query = entityManager.createNamedQuery(
				"Carrera.findAll", Carrera.class);
		List<Carrera> carreraList;
		try {
			carreraList = query.getResultList();
		} catch(NoResultException e) {
			throw new TitulacionException("No existen registros en el catálogo Carrera.");
		}
		return carreraList;
	}
}
