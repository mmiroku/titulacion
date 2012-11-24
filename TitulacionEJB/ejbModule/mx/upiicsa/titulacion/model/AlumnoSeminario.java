package mx.upiicsa.titulacion.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TblAlumnoSeminario database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "AlumnoSeminario.findAll", query = "select a from AlumnoSeminario a")})
@Table(name="TblAlumnoSeminario")

public class AlumnoSeminario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdAlumnoSeminario")
	private int idAlumnoSeminario;
	
	@JoinColumn(name="Boleta")
	private Alumno alumno;
	
	@JoinColumn(name="IdSeminario")
	private Seminario seminario;

	public AlumnoSeminario() {
	}
	
	public void setIdAlumnoSeminario(int idAlumnoSeminario) {
		this.idAlumnoSeminario = idAlumnoSeminario;
	}
	
	public int getIdAlumnoSeminario() {
		return idAlumnoSeminario;
	}
	
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Alumno getAlumno() {
		return alumno;
	}
	
	public void setSeminario(Seminario seminario) {
		this.seminario = seminario;
	}
	
	public Seminario getSeminario() {
		return seminario;
	}
	
}