package mx.upiicsa.titulacion.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TblAlumnoMateria database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "AlumnoMateria.findAll", query = "select a from AlumnoMateria a")})
@Table(name="TblAlumnoMateria")

public class AlumnoMateria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdAlumnoMateria")
	private int idAlumnoMateria;
	
	@JoinColumn(name="IdAlumnoLinea")
	private AlumnoLinea alumnoLinea;
	
	@JoinColumn(name="IdMateria")
	private Materia materia;
	
	@Column(name="Calificacion")
	private int calificacion;
	
	@Column(name="Asistencia")
	private int asistencia;
	
	@Column(name="Periodo")
	private String periodo;
	
	@Column(name="Maestro")
	private String maestro;
		
	public AlumnoMateria() {
	}
	
	public void setAlumnoLinea(AlumnoLinea alumnoLinea) {
		this.alumnoLinea = alumnoLinea;
	}
	
	public AlumnoLinea getAlumnoLinea() {
		return alumnoLinea;
	}
	
	public void setAsistencia(int asistencia) {
		this.asistencia = asistencia;
	}
	
	public int getAsistencia() {
		return asistencia;
	}
	
	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}
	
	public int getCalificacion() {
		return calificacion;
	}
	
	public void setIdAlumnoMateria(int idAlumnoMateria) {
		this.idAlumnoMateria = idAlumnoMateria;
	}
	
	public int getIdAlumnoMateria() {
		return idAlumnoMateria;
	}
	
	public void setMaestro(String maestro) {
		this.maestro = maestro;
	}
	
	public String getMaestro() {
		return maestro;
	}
	
	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	
	public Materia getMateria() {
		return materia;
	}
	
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	
	public String getPeriodo() {
		return periodo;
	}
		
}