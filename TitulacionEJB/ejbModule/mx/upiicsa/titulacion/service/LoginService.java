package mx.upiicsa.titulacion.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import mx.upiicsa.titulacion.exceptions.TitulacionException;
import mx.upiicsa.titulacion.model.Usuario;

import org.jasypt.util.password.BasicPasswordEncryptor;

@Stateless(mappedName = "ejb/LoginService")
public class LoginService {

	@Inject
	private EntityManager entityManager;

	public Usuario login(final String login, final String password) throws TitulacionException {
		TypedQuery<Usuario> query = entityManager.createNamedQuery(
				"Usuario.findByName", Usuario.class);
		query.setParameter("nombre", login);
		Usuario usuario = null;
		try {
			usuario = query.getSingleResult();
		} catch(NoResultException e) {
			throw new TitulacionException("El usuario no existe.");
		}
		final BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
		if (!passwordEncryptor.checkPassword(password, usuario.getContrasena())) {
			throw new TitulacionException("La contraseña es incorrecta.");
		}
		return usuario;
	}

}
