package mx.upiicsa.titulacion.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the TblFormaTitulacion database table.
 * 
 */
@Entity
@Table(name="TblFormaTitulacion")
public class FormaTitulacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdFormaTitulacion")
	private int idFormaTitulacion;

	@Column(name="Nombre")
	private String nombre;

	public FormaTitulacion() {
	}

	public int getIdFormaTitulacion() {
		return this.idFormaTitulacion;
	}

	public void setIdFormaTitulacion(int idFormaTitulacion) {
		this.idFormaTitulacion = idFormaTitulacion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}