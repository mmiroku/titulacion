package mx.upiicsa.titulacion.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "TblActa")
public class Acta implements Serializable {

	private static final long serialVersionUID = -6556230166749290776L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdActa")
	private Long idActa;

	@JoinColumn(name = "Boleta")
	private Alumno alumno;

	@Column(name = "NumeroActa")
	private Integer numeroActa;

	@Column(name = "NumeroLibro")
	private Integer numeroLibro;

	public Long getIdActa() {
		return idActa;
	}

	public void setIdActa(Long idActa) {
		this.idActa = idActa;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Integer getNumeroActa() {
		return numeroActa;
	}

	public void setNumeroActa(Integer numeroActa) {
		this.numeroActa = numeroActa;
	}

	public Integer getNumeroLibro() {
		return numeroLibro;
	}

	public void setNumeroLibro(Integer numeroLibro) {
		this.numeroLibro = numeroLibro;
	}

}
