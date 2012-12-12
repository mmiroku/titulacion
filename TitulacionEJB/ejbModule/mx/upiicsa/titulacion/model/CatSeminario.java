package mx.upiicsa.titulacion.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TblCarrera database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "CatSeminario.findAll", query = "select c from CatSeminario c") })
	@Table(name="TblCatalogoSeminario")
public class CatSeminario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdCatalogoSeminario")
	private int idCatalogoSeminario;

	@Column(name="Nombre")
	private String nombre;

	public CatSeminario() {
	}

	public void setIdCatalogoSeminario(int idCatalogoSeminario) {
		this.idCatalogoSeminario = idCatalogoSeminario;
	}
	
	public int getIdCatalogoSeminario() {
		return idCatalogoSeminario;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCatalogoSeminario;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		CatSeminario other = (CatSeminario) obj;
		if (idCatalogoSeminario != other.idCatalogoSeminario)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}


}