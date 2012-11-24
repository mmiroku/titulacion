package mx.upiicsa.titulacion.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
	@NamedQuery(name = "FormaTitulacion.findAll", query = "select f from FormaTitulacion f") })
@Table(name="TblFormaTitulacion")
public class FormaTitulacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdFormaTitulacion")
	private int idFormaTitulacion;

	@Column(name="Nombre")
	private String nombre;

	public FormaTitulacion() {
	}

	public int getIdFormaTitulacion() {
		return this.idFormaTitulacion;
	}

	public void setIdFormaTitulacion(int idFormaTitulacion) {
		this.idFormaTitulacion = idFormaTitulacion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}