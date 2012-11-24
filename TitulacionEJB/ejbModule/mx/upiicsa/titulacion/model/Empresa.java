package mx.upiicsa.titulacion.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TblEmpresa database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "Empresa.findAll", query = "select c from Empresa c") })
@Table(name="TblEmpresa")
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id	
	@Column(name="RFC")
	private String rfc;

	@Column(name="Nombre")
	private String nombre;
	
	@Column(name="RazonSocial")
	private String razonSocial;
	
	@Column(name="NumeroTelefono")
	private String numeroTelefono;
	
	@Column(name="Fax")
	private String fax;
	
	@Column(name="CorreoElectronico")
	private String correoElectronico;
	
	@Column(name="NombreContacto")
	private String nombreContacto;

	@JoinColumn(name="IdDireccion")
	private Direccion direccion;
	
	public Empresa() {
	}
	
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
	public Direccion getDireccion() {
		return direccion;
	}
	
	public void setFax(String fax) {
		this.fax = fax;
	}
	
	public String getFax() {
		return fax;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
	}
	
	public String getNombreContacto() {
		return nombreContacto;
	}
	
	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}
	
	public String getNumeroTelefono() {
		return numeroTelefono;
	}
	
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	
	public String getRazonSocial() {
		return razonSocial;
	}
	
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	
	public String getRfc() {
		return rfc;
	}	
}