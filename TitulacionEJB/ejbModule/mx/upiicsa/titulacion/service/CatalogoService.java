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
import mx.upiicsa.titulacion.model.Alumno;
import mx.upiicsa.titulacion.model.AlumnoLinea;
import mx.upiicsa.titulacion.model.Carrera;
import mx.upiicsa.titulacion.model.CatLinea;
import mx.upiicsa.titulacion.model.CatSeminario;
import mx.upiicsa.titulacion.model.Cedula;
import mx.upiicsa.titulacion.model.Empresa;
import mx.upiicsa.titulacion.model.FormaTitulacion;
import mx.upiicsa.titulacion.model.Maestro;
import mx.upiicsa.titulacion.model.Materia;
import mx.upiicsa.titulacion.model.Proyecto;
import mx.upiicsa.titulacion.model.Sexo;
import mx.upiicsa.titulacion.model.Linea;
import mx.upiicsa.titulacion.model.Usuario;
import mx.upiicsa.titulacion.model.Perfil;
import mx.upiicsa.titulacion.model.AlumnoMateria;


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
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<Maestro> findAllMaestro() throws TitulacionException {
		TypedQuery<Maestro> query = entityManager.createNamedQuery(
				"Maestro.findAll", Maestro.class);
		List<Maestro> maestroList;
		try {
			maestroList = query.getResultList();
		} catch(NoResultException e) {
			throw new TitulacionException("No existen registros en el catalogo de Maestros.");
		}
		return maestroList;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<FormaTitulacion> findAllFormaTitulacion() throws TitulacionException {
		TypedQuery<FormaTitulacion> query = entityManager.createNamedQuery(
				"FormaTitulacion.findAll", FormaTitulacion.class);
		List<FormaTitulacion> formaTitulacionList;
		try {
			formaTitulacionList = query.getResultList();
		} catch(NoResultException e) {
			throw new TitulacionException("No existen registros en el catalogo de Formas de Titulación.");
		}
		return formaTitulacionList;
	}
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<AlumnoLinea> findAllAlumnoLinea() throws TitulacionException {
		TypedQuery<AlumnoLinea> query = entityManager.createNamedQuery(
				"AlumnoLinea.findAll", AlumnoLinea.class);
		List<AlumnoLinea> alumnoLineaList;
		try {
			alumnoLineaList = query.getResultList();
		} catch(NoResultException e) {
			throw new TitulacionException("No existen registros en el catalogo de Lineas Asignadas a Alumnos.");
		}
		return alumnoLineaList;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<Proyecto> findAllProyecto() throws TitulacionException {
		TypedQuery<Proyecto> query = entityManager.createNamedQuery(
				"Proyecto.findAll", Proyecto.class);
		List<Proyecto> proyectoList;
		try {
			proyectoList = query.getResultList();
		} catch(NoResultException e) {
			throw new TitulacionException("No existen registros en el catalogo de Proyectos.");
		}
		return proyectoList;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<Empresa> findAllEmpresa() throws TitulacionException {
		TypedQuery<Empresa> query = entityManager.createNamedQuery(
				"Empresa.findAll", Empresa.class);
		List<Empresa> empresaList;
		try {
			empresaList = query.getResultList();
		} catch(NoResultException e) {
			throw new TitulacionException("No existen registros en el catalogo de Empresas.");
		}
		return empresaList;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<Alumno> findAllAlumno() throws TitulacionException {
		TypedQuery<Alumno> query = entityManager.createNamedQuery(
				"Alumno.findAll", Alumno.class);
		List<Alumno> alumnoList;
		try {
			alumnoList = query.getResultList();
		} catch(NoResultException e) {
			throw new TitulacionException("No existen registros en el catalogo de Alumnos.");
		}
		return alumnoList;
	}
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<Materia> findAllMateria() throws TitulacionException {
		TypedQuery<Materia> query = entityManager.createNamedQuery(
				"Materia.findAll", Materia.class);
		List<Materia> materiaList;
		try {
			materiaList = query.getResultList();
		} catch(NoResultException e) {
			throw new TitulacionException("No existen registros en el catalogo de Materia.");
		}
		return materiaList;
	}
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<AlumnoMateria> findAllAlumnoMateria() throws TitulacionException {
		TypedQuery<AlumnoMateria> query = entityManager.createNamedQuery(
				"AlumnoMateria.findAll", AlumnoMateria.class);
		List<AlumnoMateria> alumnoMateriaList;
		try {
			alumnoMateriaList = query.getResultList();
		} catch(NoResultException e) {
			throw new TitulacionException("No existen registros en el catalogo de Materia.");
		}
		return alumnoMateriaList;
	}	
}
