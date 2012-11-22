package mx.upiicsa.titulacion.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import mx.upiicsa.titulacion.exceptions.TitulacionException;
import mx.upiicsa.titulacion.model.Academia;
import mx.upiicsa.titulacion.model.Carrera;
import mx.upiicsa.titulacion.model.CatLinea;
import mx.upiicsa.titulacion.model.CatSeminario;
import mx.upiicsa.titulacion.model.Cedula;
import mx.upiicsa.titulacion.model.Sexo;
import mx.upiicsa.titulacion.model.Linea;
import mx.upiicsa.titulacion.model.Usuario;
import mx.upiicsa.titulacion.model.Perfil;


@Stateless(mappedName = "ejb/CatalogoService")
public class CatalogoService {

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
			throw new TitulacionException("No existen registros en el cat�logo Sexo.");
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
			throw new TitulacionException("No existen registros en el cat�logo Carrera.");
		}
		return carreraList;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<Academia> findAllAcademia() throws TitulacionException {
		TypedQuery<Academia> query = entityManager.createNamedQuery(
				"Academia.findAll", Academia.class);
		List<Academia> academiaList;
		try {
			academiaList = query.getResultList();
		} catch(NoResultException e) {
			throw new TitulacionException("No existen registros en el cat�logo Academia.");
		}
		return academiaList;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<Linea> findAllLinea() throws TitulacionException {
		TypedQuery<Linea> query = entityManager.createNamedQuery(
				"Linea.findAll", Linea.class);
		List<Linea> lineaList;
		try {
			lineaList = query.getResultList();
		} catch(NoResultException e) {
			throw new TitulacionException("No existen registros en el cat�logo Linea.");
		}
		return lineaList;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<CatSeminario> findAllCatSeminario() throws TitulacionException {
		TypedQuery<CatSeminario> query = entityManager.createNamedQuery(
				"CatSeminario.findAll", CatSeminario.class);
		List<CatSeminario> catSeminarioList;
		try {
			catSeminarioList = query.getResultList();
		} catch(NoResultException e) {
			throw new TitulacionException("No existen registros en el catalogo seminarios.");
		}
		return catSeminarioList;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<Cedula> findAllCedula() throws TitulacionException {
		TypedQuery<Cedula> query = entityManager.createNamedQuery(
				"Cedula.findAll", Cedula.class);
		List<Cedula> cedulaList;
		try {
			cedulaList = query.getResultList();
		} catch(NoResultException e) {
			throw new TitulacionException("No existen registros en el catalogo de cedulas.");
		}
		return cedulaList;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<Usuario> findAllUsuario() throws TitulacionException {
		TypedQuery<Usuario> query = entityManager.createNamedQuery(
				"Usuario.findAll", Usuario.class);
		List<Usuario> usuarioList;
		try {
			usuarioList = query.getResultList();
		} catch(NoResultException e) {
			throw new TitulacionException("No existen registros en el catalogo de usuarios.");
		}
		return usuarioList;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<Perfil> findAllPerfil() throws TitulacionException {
		TypedQuery<Perfil> query = entityManager.createNamedQuery(
				"Perfil.findAll", Perfil.class);
		List<Perfil> perfilList;
		try {
			perfilList = query.getResultList();
		} catch(NoResultException e) {
			throw new TitulacionException("No existen registros en el catalogo de perfiles.");
		}
		return perfilList;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<CatLinea> findAllCatLinea() throws TitulacionException {
		TypedQuery<CatLinea> query = entityManager.createNamedQuery(
				"CatLinea.findAll", CatLinea.class);
		List<CatLinea> catLineaList;
		try {
			catLineaList = query.getResultList();
		} catch(NoResultException e) {
			throw new TitulacionException("No existen registros en el catalogo de Lineas.");
		}
		return catLineaList;
	}
}
