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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carrera == null) ? 0 : carrera.hashCode());
		result = prime * result
				+ ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + linea;
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
		Linea other = (Linea) obj;
		if (carrera == null) {
			if (other.carrera != null)
				return false;
		} else if (!carrera.equals(other.carrera))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (linea != other.linea)
			return false;
		return true;
	}
	
}
