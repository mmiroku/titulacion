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
import mx.upiicsa.titulacion.model.CatLinea;

@Stateless(mappedName = "ejb/CatLineaService")
public class CatLineaService implements Serializable {
	
private static final long serialVersionUID = -8510737783635751315L;
	
	@Inject
	private EntityManager entityManager;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(CatLinea catLinea) {	
		entityManager.persist(catLinea);
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<CatLinea> findAllCatLinea() throws TitulacionException {
		TypedQuery<CatLinea> query = entityManager.createNamedQuery(
				"CatLinea.findAll", CatLinea.class);
		List<CatLinea> catLineaList = new ArrayList<CatLinea>();
		try {
			catLineaList = query.getResultList();
		} catch(NoResultException e) {
			
		}
		return catLineaList;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void update(CatLinea catLinea) {		
		entityManager.merge(catLinea);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(int IdCatLinea) throws TitulacionException {
		CatLinea catLinea = entityManager.find(CatLinea.class, IdCatLinea);
		System.out.println("encontre seminario: " + catLinea);
		if (catLinea == null) {
			System.out.println("uchas fue error");
			throw new TitulacionException("El CatLinea no existe.");
		}
		entityManager.remove(catLinea);
		System.out.println("ps si lo elimine");
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<CatLinea> findByFilter(CatLinea filtro) throws TitulacionException {				
		List<CatLinea> catLineaList = new ArrayList<CatLinea>();		
		return catLineaList;
	}
}
