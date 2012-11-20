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
	
}