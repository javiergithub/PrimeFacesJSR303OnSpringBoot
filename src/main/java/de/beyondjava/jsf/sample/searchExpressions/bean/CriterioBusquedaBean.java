package de.beyondjava.jsf.sample.searchExpressions.bean;

import java.io.Serializable;

import de.beyondjava.dominio.reporte.CriterioBusqueda;
import de.beyondjava.dominio.reporte.CriterioBusquedaLocalidad;


/**
 * A backing bean for the main hotel search form. Encapsulates the criteria
 * needed to perform a hotel search.
 */
public class CriterioBusquedaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private CriterioBusqueda criterioBusqueda;
	
	private String cadenaBusqueda = "";

	private boolean sumarizado = false;
	
	private String accion;
	
	private int tamanioPagina = 5;

	private int pagina = 1;

	private String ordenaPor = "descripcion";


	private CriterioBusquedaLocalidad criterioBusquedaLocalidad;



	public CriterioBusquedaBean() {
		super();
	}

	public String getCadenaBusqueda() {
		return cadenaBusqueda;
	}

	public void setCadenaBusqueda(String cadenaBusqueda) {
		this.cadenaBusqueda = cadenaBusqueda;
	}

	public int getTamanioPagina() {
		return tamanioPagina;
	}

	public void setTamanioPagina(int tamanioPagina) {
		this.tamanioPagina = tamanioPagina;
	}

	public int getPagina() {
		return pagina;
	}

	public void setPagina(int pagina) {
		this.pagina = pagina;
	}

	public String getOrdenaPor() {
		return ordenaPor;
	}

	public void setOrdenaPor(String ordenaPor) {
		this.ordenaPor = ordenaPor;
	}

	public void paginaSiguiente() {
		pagina++;
	}

	public void paginaAnterior() {
		pagina--;
	}

	public void reseteaPagina() {
		pagina = 0;
		ordenaPor = "descripcion";
	}

	@Override
	public String toString() {
		return "[Criterio Busqueda cadenaBusqueda = '" + cadenaBusqueda + "'";
	}


	public boolean isSumarizado() {
		return sumarizado;
	}

	public void setSumarizado(boolean sumarizado) {
		this.sumarizado = sumarizado;
	}

	public CriterioBusqueda getCriterioBusqueda() {
		return criterioBusqueda;
	}

	public void setCriterioBusqueda(CriterioBusqueda criterioBusqueda) {
		this.criterioBusqueda = criterioBusqueda;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		if (this.accion == null || this.accion.isEmpty())
			this.accion = accion;
	}

	public CriterioBusquedaLocalidad getCriterioBusquedaLocalidad() {
		return criterioBusquedaLocalidad;
	}
	public void setCriterioBusquedaLocalidad(
			CriterioBusquedaLocalidad criterioBusquedaLocalidad) {
		this.criterioBusquedaLocalidad = criterioBusquedaLocalidad;
	}


}