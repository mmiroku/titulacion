package mx.upiicsa.titulacion.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the TblEstatus database table.
 * 
 */
@Entity
@Table(name="TblEstatus")
public class Estatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdEstatus")
	private int idEstatus;

	@Column(name="Descripcion")
	private String descripcion;

	public Estatus() {
	}

	public Estatus(int idEstatus) {
		this.idEstatus = idEstatus;
	}

	public int getIdEstatus() {
		return this.idEstatus;
	}

	public void setIdEstatus(int idEstatus) {
		this.idEstatus = idEstatus;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}