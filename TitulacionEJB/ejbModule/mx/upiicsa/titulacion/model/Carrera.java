package mx.upiicsa.titulacion.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TblCarrera database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "Carrera.findAll", query = "select c from Carrera c") })
@Table(name="TblCarrera")
public class Carrera implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdCarrera")
	private int idCarrera;

	@Column(name="Nombre")
	private String nombre;

	public Carrera() {
	}

	public int getIdCarrera() {
		return this.idCarrera;
	}

	public void setIdCarrera(int idCarrera) {
		this.idCarrera = idCarrera;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}