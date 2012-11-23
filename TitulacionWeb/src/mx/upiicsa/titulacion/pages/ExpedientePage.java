package mx.upiicsa.titulacion.pages;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import mx.upiicsa.titulacion.model.Alumno;
import mx.upiicsa.titulacion.model.Expediente;

@Named("pExpediente")
@SessionScoped
public class ExpedientePage implements Serializable {

	private static final long serialVersionUID = -8594287843676663729L;

	private Expediente expediente;

	private List<Expediente> expedientes;
	
	private List<Alumno> pasantesSeleccionados = new ArrayList<Alumno>();

	public Expediente getExpediente() {
		return expediente;
	}

	public void setExpediente(Expediente expediente) {
		this.expediente = expediente;
	}

	public List<Expediente> getExpedientes() {
		return expedientes;
	}

	public void setExpedientes(List<Expediente> expedientes) {
		this.expedientes = expedientes;
	}

	public List<Alumno> getPasantesSeleccionados() {
		return pasantesSeleccionados;
	}

	public void setPasantesSeleccionados(List<Alumno> pasantesSeleccionados) {
		this.pasantesSeleccionados = pasantesSeleccionados;
	}

}
