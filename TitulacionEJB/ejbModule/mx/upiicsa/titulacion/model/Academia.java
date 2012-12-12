package mx.upiicsa.titulacion.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TblAcademia database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "Academia.findAll", query = "select a from Academia a") })
@Table(name="TblAcademia")
public class Academia implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdAcademia")
	private int IdAcademia;
	
	@Column(name="Nombre")
	private String Nombre;
	
	public Academia(){		
	}

	public void setIdAcademia(int IdAcademia) {
		this.IdAcademia = IdAcademia;
	}

	public int getIdAcademia() {
		return this.IdAcademia;
	}
	
	public String getNombre() {
		return this.Nombre;
	}

	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + IdAcademia;
		result = prime * result + ((Nombre == null) ? 0 : Nombre.hashCode());
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
		Academia other = (Academia) obj;
		if (IdAcademia != other.IdAcademia)
			return false;
		if (Nombre == null) {
			if (other.Nombre != null)
				return false;
		} else if (!Nombre.equals(other.Nombre))
			return false;
		return true;
	}

}