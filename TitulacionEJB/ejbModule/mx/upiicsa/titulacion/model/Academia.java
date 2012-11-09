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
}