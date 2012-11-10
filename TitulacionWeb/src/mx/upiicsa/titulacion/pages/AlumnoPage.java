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

	private List<Alumno> alumnos = new ArrayList<Alumno>();//generarAlumnos();

//	private List<Alumno> generarAlumnos() {
//		List<Alumno> alumnos = new ArrayList<Alumno>();
//
//		alumnos.add(new Alumno("2005601688", "Flores", "Mendez", "Misael",
//				"I.Transporte", "Quinto"));
//		alumnos.add(new Alumno("2006602675", "Martínez", "Hernández", "Edgar",
//				"C. Informática", "Quinto"));
//		alumnos.add(new Alumno("2006600867", "Arcos", "Hernández", "Irvin",
//				"Administración", "Quinto"));
//		alumnos.add(new Alumno("2005601394", "Hernández", "Islas", "Edna",
//				"I.Transporte", "Quinto"));
//		alumnos.add(new Alumno("2007600784", "Sardinas", "Sánchez", "Mauricio",
//				"I. Informática", "Sexto"));
//		alumnos.add(new Alumno("2005601786", "García", "Nieto", "Carlos Iván",
//				"C. Informática", "Sexto"));
//		alumnos.add(new Alumno("2004600795", "Herrera", "Maldonado",
//				"Victor Hugo", "Administración", "Sexto"));
//		alumnos.add(new Alumno("2006602345", "Camacho", "Carbajal",
//				"Luis Daniel", "C. Informática", "Septimo"));
//		alumnos.add(new Alumno("2007601256", "Gutierrez", "Camacho", "Circe",
//				"I. Informática", "Octavo"));
//
//		return alumnos;
//	}

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
