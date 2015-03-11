package de.beyondjava.dominio.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Embeddable
public class Activa implements Serializable{

	private static final long serialVersionUID = 1L;
	private String vigenciaId;
	private Date fechaActivacion;
	private Date fechaDesactivacion;
	private Date fechaBaja;

	public Activa() {
		super();
		setVigencia(Vigencia.ACTIVO);
	}

	public Activa(Vigencia activo) {
		setVigencia(activo);
	}

	@Column(length = 1)
	public String getVigenciaId() {
		return vigenciaId;
	}

	public void setVigenciaId(String vigenciaId) {
		this.vigenciaId = vigenciaId;
	}

	@Transient
	public Vigencia getVigencia() {
		return Vigencia.parse(vigenciaId);
	}

	public void setVigencia(Vigencia vigencia) {
		this.vigenciaId = vigencia.getVigenciaId();
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getFechaActivacion() {
		return fechaActivacion;
	}

	public void setFechaActivacion(Date fechaActivacion) {
		this.fechaActivacion = fechaActivacion;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getFechaDesactivacion() {
		return fechaDesactivacion;
	}

	public void setFechaDesactivacion(Date fechaDesactivacion) {
		this.fechaDesactivacion = fechaDesactivacion;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public void verificarVigencia() {
			switch (getVigencia()) {
			case ACTIVO:
				if (fechaActivacion == null)
					fechaActivacion = new Date();
				if (fechaDesactivacion != null
						&& fechaActivacion.compareTo(fechaDesactivacion) < 0)
					fechaActivacion = new Date();
				break;
			case NO_ACTIVO:
				if (fechaDesactivacion == null)
					fechaDesactivacion = new Date();
				if (fechaActivacion != null
						&& fechaDesactivacion.compareTo(fechaActivacion) < 0)
					fechaDesactivacion = new Date();
				break;
			case BAJA:
				fechaBaja = new Date();
				break;
			default:
				break;
			}

	}
}
