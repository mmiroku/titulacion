package mx.upiicsa.titulacion.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TblLineas database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "CatLinea.findAll", query = "select c from CatLinea c") })
	@Table(name="TblCatalogoLineas")

public class CatLinea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdLinea")
	private int idLinea;

	@Column(name="Descripcion")
	private String descripcion;

	@JoinColumn(name="IdCarrera")
	private Carrera carrera;
	
	public CatLinea() {
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}
	
	public Carrera getCarrera() {
		return carrera;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setIdLinea(int idLinea) {
		this.idLinea = idLinea;
	}
	
	public int getIdLinea() {
		return idLinea;
	}	
}