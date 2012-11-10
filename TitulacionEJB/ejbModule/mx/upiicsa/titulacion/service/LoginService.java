package mx.upiicsa.titulacion.service;

import javax.ejb.Stateless;

import mx.upiicsa.titulacion.exceptions.TitulacionException;

@Stateless(mappedName = "ejb/LoginService")
public class LoginService {

	public String login(String login, String password) throws TitulacionException {
		if (!"admin".equals(login)) {
			throw new TitulacionException("El usuario no existe.");
		}
		if (!"pass".equals(password)) {
			throw new TitulacionException("La contraseña es incorrecta.");
		}
		return login;
	}

}
