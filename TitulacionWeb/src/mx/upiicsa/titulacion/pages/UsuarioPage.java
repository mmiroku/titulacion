package mx.upiicsa.titulacion.pages;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import mx.upiicsa.titulacion.model.Usuario;

@Named("pUsuario")
@SessionScoped
public class UsuarioPage implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Usuario usuario = new Usuario();
	
	private Usuario filtro = new Usuario(); 
	
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	
	public void setFiltro(Usuario filtro) {
		this.filtro = filtro;
	}
	
	public Usuario getFiltro() {
		return filtro;
	}
		
}
