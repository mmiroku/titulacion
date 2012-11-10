package mx.upiicsa.titulacion.pages;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("pLogin")
@RequestScoped
public class LoginPage implements Serializable {

	private static final long serialVersionUID = -2577463178337659522L;

	private String login;

	private String password;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
