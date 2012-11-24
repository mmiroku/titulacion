package mx.upiicsa.titulacion.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TblProyecto database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "Proyecto.findAll", query = "select p from Proyecto p") })
@Table(name="TblProyecto")
public class Proyecto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdProyecto")
	private int idProyecto;

	@JoinColumn(name="RFC")
	private Empresa empresa;
	
	@Column(name="Nombre")
	private String nombre;

	public Proyecto() {
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}
	
	public void setIdProyecto(int idProyecto) {
		this.idProyecto = idProyecto;
	}
	
	public int getIdProyecto() {
		return idProyecto;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}

}