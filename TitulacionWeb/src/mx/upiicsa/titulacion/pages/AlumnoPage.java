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
//		alumnos.add(new Alumno("2006602675", "Mart�nez", "Hern�ndez", "Edgar",
//				"C. Inform�tica", "Quinto"));
//		alumnos.add(new Alumno("2006600867", "Arcos", "Hern�ndez", "Irvin",
//				"Administraci�n", "Quinto"));
//		alumnos.add(new Alumno("2005601394", "Hern�ndez", "Islas", "Edna",
//				"I.Transporte", "Quinto"));
//		alumnos.add(new Alumno("2007600784", "Sardinas", "S�nchez", "Mauricio",
//				"I. Inform�tica", "Sexto"));
//		alumnos.add(new Alumno("2005601786", "Garc�a", "Nieto", "Carlos Iv�n",
//				"C. Inform�tica", "Sexto"));
//		alumnos.add(new Alumno("2004600795", "Herrera", "Maldonado",
//				"Victor Hugo", "Administraci�n", "Sexto"));
//		alumnos.add(new Alumno("2006602345", "Camacho", "Carbajal",
//				"Luis Daniel", "C. Inform�tica", "Septimo"));
//		alumnos.add(new Alumno("2007601256", "Gutierrez", "Camacho", "Circe",
//				"I. Inform�tica", "Octavo"));
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
