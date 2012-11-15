package mx.upiicsa.titulacion.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the TblAcademia database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "Linea.findAll", query = "select l from Linea l") })
@Table(name="TblCatalogoLineas")

public class Linea implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdLinea")
	private int linea;
	
	@Column(name="Descripcion")
	private String descripcion;
	
	@JoinColumn(name="IdCarrera")
	private Carrera carrera;
	
	public Linea(){		
	}
	
	public void setLinea(int linea) {
		this.linea = linea;
	}
	
	public int getLinea() {
		return linea;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}
	
	public Carrera getCarrera() {
		return carrera;
	}
	
}
