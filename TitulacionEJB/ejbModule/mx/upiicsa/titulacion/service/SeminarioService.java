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
import mx.upiicsa.titulacion.model.Seminario;

@Stateless(mappedName = "ejb/SeminarioService")
public class SeminarioService implements Serializable {
	
private static final long serialVersionUID = -8510737783635751315L;
	
	@Inject
	private EntityManager entityManager;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(Seminario seminario) {	
		entityManager.persist(seminario);
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<Seminario> findAllSeminario() throws TitulacionException {
		TypedQuery<Seminario> query = entityManager.createNamedQuery(
				"Seminario.findAll", Seminario.class);
		List<Seminario> seminarioList = new ArrayList<Seminario>();
		try {
			seminarioList = query.getResultList();
		} catch(NoResultException e) {
			
		}
		return seminarioList;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void update(Seminario seminario) {		
		entityManager.merge(seminario);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(int IdSeminario) throws TitulacionException {
		Seminario seminario = entityManager.find(Seminario.class, IdSeminario);
		System.out.println("encontre seminario: " + seminario);
		if (seminario == null) {
			System.out.println("uchas fue error");
			throw new TitulacionException("El seminario no existe.");
		}
		entityManager.remove(seminario);
		System.out.println("ps si lo elimine");
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<Seminario> findByFilter(Seminario filtro) throws TitulacionException {
		TypedQuery<Seminario> query = entityManager.createNamedQuery(
				"Seminario.findByFilter", Seminario.class);
				
		if (filtro.getCatSeminario() != null) {
			query.setParameter("seminario", filtro.getCatSeminario().getIdCatalogoSeminario());
		} else {
			query.setParameter("seminario", 0);
		}
		
		if (filtro.getCedula() != null){
			query.setParameter("cedula", filtro.getCedula().getNumeroCedula());
		} else {
			query.setParameter("cedula", "");
		}
		
		query.setParameter("periodo","%" + filtro.getPeriodo() + "%");
		query.setParameter("sede", filtro.getSede());
		
		List<Seminario> seminarioList = new ArrayList<Seminario>();
		try {
			seminarioList = query.getResultList();
		} catch(NoResultException e) {
			
		}
		return seminarioList;
	}
}
