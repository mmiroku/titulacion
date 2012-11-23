package mx.upiicsa.titulacion.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TblSexo database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "Usuario.findAll", query = "select u from Usuario u"),
	@NamedQuery(name = "Usuario.findByName", query = "select u from Usuario u where u.nombre = :nombre"),
	@NamedQuery(name = "Usuario.findByFilter", query = "select u from Usuario u where ((:nombre is null or :nombre = '' ) or u.nombre = :nombre) and ((:idPerfil is null or :idPerfil = '') or u.perfil.idPerfil = :idPerfil)")})
@Table(name="TblUsuario")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdUsuario")
	private int idUsuario;

	@Column(name="Nombre")
	private String nombre;
	
	@Column(name="Contrasena")
	private String contrasena;
	
	@JoinColumn(name="IdPerfil")
	private Perfil perfil;

	public Usuario() {
	}
	
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	public String getContrasena() {
		return contrasena;
	}
	
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public int getIdUsuario() {
		return idUsuario;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	
	public Perfil getPerfil() {
		return perfil;
	}
	
}