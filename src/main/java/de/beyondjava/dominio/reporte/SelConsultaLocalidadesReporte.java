package de.beyondjava.dominio.reporte;

import java.io.Serializable;

public class SelConsultaLocalidadesReporte   implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;
	private String localidad;

	
	public SelConsultaLocalidadesReporte(String localidad) {
		super();
		this.localidad = localidad;
	}

	public SelConsultaLocalidadesReporte(Long id, String localidad) {
		super();
		this.id = id;
		this.localidad = localidad;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public SelConsultaLocalidadesReporte() {
		// TODO Auto-generated constructor stub
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
