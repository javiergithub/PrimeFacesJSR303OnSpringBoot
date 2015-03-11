package de.beyondjava.dominio.reporte;

import java.io.Serializable;

public class CriterioBusquedaLocalidad   implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String localidad;

	
	public CriterioBusquedaLocalidad(String localidad) {
		super();
		this.setLocalidad(localidad);
	}

	public CriterioBusquedaLocalidad(Integer id, String localidad) {
		super();
		this.id = id;
		this.setLocalidad(localidad);
	}

	public CriterioBusquedaLocalidad() {
		// TODO Auto-generated constructor stub
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
}
