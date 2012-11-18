package mx.upiicsa.titulacion.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TblCarrera database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "Cedula.findAll", query = "select c from Cedula c") })
	@Table(name="TblCedula")
public class Cedula implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id	
	@Column(name="NumeroCedula")
	private String numeroCedula;
	
	@JoinColumn(name="IdMaestro")	
	private Maestro maestro;

	@Column(name="Titulo")
	private String titulo;
	public Cedula() {
	}

	public void setNumeroCedula(String numeroCedula) {
		this.numeroCedula = numeroCedula;
	}
	
	public String getNumeroCedula() {
		return numeroCedula;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setMaestro(Maestro maestro) {
		this.maestro = maestro;
	}
	
	public Maestro getMaestro() {
		return maestro;
	}
}