package mx.upiicsa.titulacion.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TblSexo database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "Perfil.findAll", query = "select p from Perfil p") })
@Table(name="TblPerfil")
public class Perfil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdPerfil")
	private int idPerfil;

	@Column(name="Perfil")
	private String perfil;

	public Perfil() {
	}
	
	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}
	
	public int getIdPerfil() {
		return idPerfil;
	}
	
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
	public String getPerfil() {
		return perfil;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idPerfil;
		result = prime * result + ((perfil == null) ? 0 : perfil.hashCode());
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
		Perfil other = (Perfil) obj;
		if (idPerfil != other.idPerfil)
			return false;
		if (perfil == null) {
			if (other.perfil != null)
				return false;
		} else if (!perfil.equals(other.perfil))
			return false;
		return true;
	}
	
}