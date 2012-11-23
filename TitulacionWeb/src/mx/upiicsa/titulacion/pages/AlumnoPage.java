package mx.upiicsa.titulacion.pages;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import mx.upiicsa.titulacion.model.Alumno;

@Named("pAlumno")
@SessionScoped
public class AlumnoPage implements Serializable {

	private static final long serialVersionUID = 1L;

	private Alumno alumno = new Alumno();
	
	private Alumno filtro = new Alumno();

	private List<Alumno> alumnos = new ArrayList<Alumno>();

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public Alumno getFiltro() {
		return filtro;
	}

	public void setFiltro(Alumno filtro) {
		this.filtro = filtro;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

}
