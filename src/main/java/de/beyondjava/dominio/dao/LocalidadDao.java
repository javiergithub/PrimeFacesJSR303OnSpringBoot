package de.beyondjava.dominio.dao;

import java.util.List;

import de.beyondjava.dominio.excepcion.AplicException;
import de.beyondjava.dominio.reporte.CriterioBusquedaLocalidad;
import de.beyondjava.dominio.reporte.SelConsultaLocalidadesReporte;

public interface LocalidadDao {
	List<SelConsultaLocalidadesReporte> obtenerLocalidadesCriterioBusquedaPaginada(
			CriterioBusquedaLocalidad criterioBusquedaLocalidad,
			int pagina, int tamanioPagina) throws AplicException;
	int obtenerLocalidadesCriterioBusquedaTotal(
			CriterioBusquedaLocalidad criterioBusquedaLocalidad) throws AplicException;	
}
