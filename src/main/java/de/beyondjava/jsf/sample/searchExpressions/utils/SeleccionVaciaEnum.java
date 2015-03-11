package de.beyondjava.jsf.sample.searchExpressions.utils;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="seleccionVaciaBack")
@ApplicationScoped
public enum SeleccionVaciaEnum {
	SELECCIONEUNO("","Seleccione uno");
	private final String valor;
	private final String nombre;
	private SeleccionVaciaEnum(String valor, String nombre) {
		this.valor = valor;
		this.nombre = nombre;
	}
	public String getValor() {
		return valor;
	}
	public String getNombre() {
		return nombre;
	}
	
	
}
