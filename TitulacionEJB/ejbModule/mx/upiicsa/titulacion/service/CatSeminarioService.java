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
import mx.upiicsa.titulacion.model.CatSeminario;

@Stateless(mappedName = "ejb/CatSeminarioService")
public class CatSeminarioService implements Serializable {
	
private static final long serialVersionUID = -8510737783635751315L;
	
	@Inject
	private EntityManager entityManager;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(CatSeminario catSeminario) {	
		entityManager.persist(catSeminario);
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<CatSeminario> findAllCatSeminario() throws TitulacionException {
		TypedQuery<CatSeminario> query = entityManager.createNamedQuery(
				"CatSeminario.findAll", CatSeminario.class);
		List<CatSeminario> catSeminarioList = new ArrayList<CatSeminario>();
		try {
			catSeminarioList = query.getResultList();
		} catch(NoResultException e) {
			
		}
		return catSeminarioList;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void update(CatSeminario catSeminario) {		
		entityManager.merge(catSeminario);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(int IdCatSeminario) throws TitulacionException {
		CatSeminario catSeminario = entityManager.find(CatSeminario.class, IdCatSeminario);
		System.out.println("encontre seminario: " + catSeminario);
		if (catSeminario == null) {
			System.out.println("uchas fue error");
			throw new TitulacionException("El CatSeminario no existe.");
		}
		entityManager.remove(catSeminario);
		System.out.println("ps si lo elimine");
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<CatSeminario> findByFilter(CatSeminario filtro) throws TitulacionException {				
		List<CatSeminario> catSeminarioList = new ArrayList<CatSeminario>();		
		return catSeminarioList;
	}
}
