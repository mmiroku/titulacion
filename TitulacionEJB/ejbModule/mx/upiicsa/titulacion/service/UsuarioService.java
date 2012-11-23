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
import mx.upiicsa.titulacion.model.Usuario;
import mx.upiicsa.titulacion.util.EncryptionUtil;

@Stateless(mappedName = "ejb/UsuarioService")
public class UsuarioService implements Serializable {
	
private static final long serialVersionUID = -8510737783635751315L;
	
	@Inject
	private EntityManager entityManager;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(Usuario usuario) {
		String encryptedPassword = EncryptionUtil.encriptarPassword(usuario
				.getContrasena());
		usuario.setContrasena(encryptedPassword);
		entityManager.persist(usuario);
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<Usuario> findAllUsuario() throws TitulacionException {
		TypedQuery<Usuario> query = entityManager.createNamedQuery(
				"Usuario.findAll", Usuario.class);
		List<Usuario> usuarioList = new ArrayList<Usuario>();
		try {
			usuarioList = query.getResultList();
		} catch(NoResultException e) {
			
		}
		return usuarioList;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void update(Usuario usuario) {
//		TODO No permitir actualizar contraseña sino cambiarla
//		Usuario regUser = entityManager.find(Usuario.class, usuario.getIdUsuario());
//		if (!usuario.getContrasena().equals(regUser.getContrasena())) {
//			String encryptedPassword = EncryptionUtil.encriptarPassword(usuario
//					.getContrasena());
//			usuario.setContrasena(encryptedPassword);
//		}
		entityManager.merge(usuario);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(int IdUsuario) throws TitulacionException {
		Usuario usuario = entityManager.find(Usuario.class, IdUsuario);
		System.out.println("encontre seminario: " + usuario);
		if (usuario == null) {
			System.out.println("uchas fue error");
			throw new TitulacionException("El Usuario no existe.");
		}
		entityManager.remove(usuario);
		System.out.println("ps si lo elimine");
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<Usuario> findByFilter(Usuario filtro) throws TitulacionException {
		TypedQuery<Usuario> query = entityManager.createNamedQuery(
				"Usuario.findByFilter", Usuario.class);
									
		if (filtro.getPerfil() != null){
			query.setParameter("idPerfil", filtro.getPerfil().getIdPerfil());
		} else {
			query.setParameter("idPerfil", 0);
		}
				
		query.setParameter("nombre",filtro.getNombre());
		
		List<Usuario> usuarioList = new ArrayList<Usuario>();
		try {
			usuarioList = query.getResultList();
		} catch(NoResultException e) {
			
		}
		return usuarioList;
	}
}
