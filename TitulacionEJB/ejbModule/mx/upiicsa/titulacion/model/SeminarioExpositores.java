package mx.upiicsa.titulacion.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TblSeminarioExpositores database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "SeminarioExpositores.findAll", query = "select a from SeminarioExpositores a")})
@Table(name="TblSeminarioExpositores")

public class SeminarioExpositores implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdSeminarioExpositores")
	private int idSeminarioExpositores;
	
	@JoinColumn(name="IdSeminario")
	private Seminario seminario;
	
	@JoinColumn(name="NumeroCedula")
	private Cedula cedula;

	public SeminarioExpositores() {
	}	
	
	public void setCedula(Cedula cedula) {
		this.cedula = cedula;
	}
	
	public Cedula getCedula() {
		return cedula;
	}
	
	public void setIdSeminarioExpositores(int idSeminarioExpositores) {
		this.idSeminarioExpositores = idSeminarioExpositores;
	}
	
	public int getIdSeminarioExpositores() {
		return idSeminarioExpositores;
	}
	
	public Seminario getSeminario() {
		return seminario;
	}
	
	public void setSeminario(Seminario seminario) {
		this.seminario = seminario;
	}
	
}