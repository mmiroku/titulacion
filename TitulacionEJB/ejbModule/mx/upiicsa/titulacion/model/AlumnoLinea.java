package mx.upiicsa.titulacion.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TblAlumnoLinea database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "AlumnoLinea.findAll", query = "select a from AlumnoLinea a"),
	@NamedQuery(name = "AlumnoLinea.findByFilter", query = "select a from AlumnoLinea a where ((:alumno is null or :alumno = '') or a.alumno.boleta = :alumno) and ((:linea is null or :linea = '') or a.linea.linea = :linea) and ((:proyecto is null or :proyecto = '') or a.proyecto.idProyecto = :proyecto)")})
@Table(name="TblAlumnoLinea")

public class AlumnoLinea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdAlumnoLinea")
	private int idAlumnoLinea;
	
	@JoinColumn(name="IdProyecto")
	private Proyecto proyecto;
	
	@JoinColumn(name="IdLinea")
	private Linea linea;
	
	@JoinColumn(name="Boleta")
	private Alumno alumno;
	
	public AlumnoLinea() {
	}
	
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	
	public Alumno getAlumno() {
		return alumno;
	}
	
	public void setIdAlumnoLinea(int idAlumnoLinea) {
		this.idAlumnoLinea = idAlumnoLinea;
	}
	
	public int getIdAlumnoLinea() {
		return idAlumnoLinea;
	}
	
	public void setLinea(Linea linea) {
		this.linea = linea;
	}
	
	public Linea getLinea() {
		return linea;
	}
	
	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}
	
	public Proyecto getProyecto() {
		return proyecto;
	}
		
}