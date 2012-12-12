package mx.upiicsa.titulacion.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TblCarrera database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "Cedula.findAll", query = "select c from Cedula c"),
	@NamedQuery(name = "Cedula.findByFilter", query = "select c from Cedula c where ((:cedula is null or :cedula = '' ) or c.numeroCedula = :cedula) and ((:titulo is null or :titulo = '') or c.titulo = :titulo )")})
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maestro == null) ? 0 : maestro.hashCode());
		result = prime * result
				+ ((numeroCedula == null) ? 0 : numeroCedula.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cedula other = (Cedula) obj;
		if (maestro == null) {
			if (other.maestro != null)
				return false;
		} else if (!maestro.equals(other.maestro))
			return false;
		if (numeroCedula == null) {
			if (other.numeroCedula != null)
				return false;
		} else if (!numeroCedula.equals(other.numeroCedula))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
}