package mx.upiicsa.titulacion.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TblActaExpediente")
public class ActaExpediente implements Serializable {

	private static final long serialVersionUID = -1456679798936708459L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdActaExpediente")
	private Long id;
	
	@JoinColumn(name="IdActa")
	private Acta acta;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="IdExpediente")
	private Expediente expediente;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Acta getActa() {
		return acta;
	}

	public void setActa(Acta acta) {
		this.acta = acta;
	}

	public Expediente getExpediente() {
		return expediente;
	}

	public void setExpediente(Expediente expediente) {
		this.expediente = expediente;
	}

}
