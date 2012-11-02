package mx.upiicsa.titulacion.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TblSexo database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "Sexo.findAll", query = "select s from Sexo s") })
@Table(name="TblSexo")
public class Sexo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdSexo")
	private int idSexo;

	@Column(name="Descripcion")
	private String descripcion;

	public Sexo() {
	}

	public int getIdSexo() {
		return this.idSexo;
	}

	public void setIdSexo(int idSexo) {
		this.idSexo = idSexo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}