package mx.upiicsa.titulacion.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;


/**
 * The persistent class for the TblExpediente database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "Expediente.findAll", query = "select e from Expediente e") })
@Table(name="TblExpediente")
public class Expediente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdExpediente")
	private Long idExpediente;

	@Column(name="Descripcion")
	private String descripcion;

	@Column(name="NumeroImpresion")
	private Long numeroImpresion;

	@JoinColumn(name="IdFormaTitulacion")
	private FormaTitulacion formaTitulacion;

	@Column(name = "FechaInicio")
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date fechaInicio;

	@Column(name = "FechaFin")
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date fechaFin;

	@Column(name = "Lugar")
	private String lugar;
	
	@Column(name = "Auditorio")
	private String auditorio;

	@Column(name = "Tema")
	private String tema;

	@JoinColumn(name = "CedulaDirector")
	private Cedula cedulaDirector;
	
	@JoinColumn(name = "CedulaPresidente")
	private Cedula cedulaPresidente;
	
	@JoinColumn(name = "CedulaSecretario")
	private Cedula cedulaSecretario;
	
	@JoinColumn(name = "CedulaVocal1")
	private Cedula cedulaVocal1;
	
	@JoinColumn(name = "CedulaVocal2")
	private Cedula cedulaVocal2;
	
	@JoinColumn(name = "CedulaVocal3")
	private Cedula cedulaVocal3;

	@JoinColumn(name = "IdEstatus")
	private Estatus estatus;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "expediente")
	private List<ActaExpediente> actaExpedienteList;

	public Expediente() {
	}

	public Long getIdExpediente() {
		return this.idExpediente;
	}

	public void setIdExpediente(Long idExpediente) {
		this.idExpediente = idExpediente;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getNumeroImpresion() {
		return this.numeroImpresion;
	}

	public void setNumeroImpresion(Long numeroImpresion) {
		this.numeroImpresion = numeroImpresion;
	}

	public List<ActaExpediente> getActaExpedienteList() {
		return actaExpedienteList;
	}

	public void setActaExpedienteList(List<ActaExpediente> actaExpedienteList) {
		this.actaExpedienteList = actaExpedienteList;
	}

	public FormaTitulacion getFormaTitulacion() {
		return formaTitulacion;
	}

	public void setFormaTitulacion(FormaTitulacion formaTitulacion) {
		this.formaTitulacion = formaTitulacion;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getAuditorio() {
		return auditorio;
	}

	public void setAuditorio(String auditorio) {
		this.auditorio = auditorio;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public Cedula getCedulaDirector() {
		return cedulaDirector;
	}

	public void setCedulaDirector(Cedula cedulaDirector) {
		this.cedulaDirector = cedulaDirector;
	}

	public Cedula getCedulaPresidente() {
		return cedulaPresidente;
	}

	public void setCedulaPresidente(Cedula cedulaPresidente) {
		this.cedulaPresidente = cedulaPresidente;
	}

	public Cedula getCedulaSecretario() {
		return cedulaSecretario;
	}

	public void setCedulaSecretario(Cedula cedulaSecretario) {
		this.cedulaSecretario = cedulaSecretario;
	}

	public Cedula getCedulaVocal1() {
		return cedulaVocal1;
	}

	public void setCedulaVocal1(Cedula cedulaVocal1) {
		this.cedulaVocal1 = cedulaVocal1;
	}

	public Cedula getCedulaVocal2() {
		return cedulaVocal2;
	}

	public void setCedulaVocal2(Cedula cedulaVocal2) {
		this.cedulaVocal2 = cedulaVocal2;
	}

	public Cedula getCedulaVocal3() {
		return cedulaVocal3;
	}

	public void setCedulaVocal3(Cedula cedulaVocal3) {
		this.cedulaVocal3 = cedulaVocal3;
	}

	public Estatus getEstatus() {
		return estatus;
	}

	public void setEstatus(Estatus estatus) {
		this.estatus = estatus;
	}

}