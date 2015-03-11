package de.beyondjava.dominio.servicio;

import java.util.List;

import de.beyondjava.dominio.excepcion.AplicException;
import de.beyondjava.dominio.excepcion.PrestadoresClaveNaturalDataExcepcion;
import de.beyondjava.dominio.modelo.Localidad;
import de.beyondjava.dominio.modelo.Vigencia;
import de.beyondjava.dominio.reporte.CriterioBusquedaLocalidad;
import de.beyondjava.dominio.reporte.SelConsultaLocalidadesReporte;


public interface ServicioConfiguracion {
	
	void guardarLocalidad(Localidad localidad) throws PrestadoresClaveNaturalDataExcepcion;

	void actualizarLocalidad(Localidad localidad) throws PrestadoresClaveNaturalDataExcepcion;

	List<SelConsultaLocalidadesReporte> obtenerLocalidadesCriterioBusquedaPaginada(
			CriterioBusquedaLocalidad criterioBusquedaLocalidad,
			int pagina, int tamanioPagina) throws AplicException;

	int obtenerLocalidadesCriterioBusquedaTotal(
			CriterioBusquedaLocalidad criterioBusquedaLocalidad) throws AplicException;

	Localidad obtenerLocalidadCompleto(String localidadId);
	
	//
	
	
	//
	
	List<Localidad> obtenerLocalidades(Vigencia baja) throws AplicException;
	Localidad obtenerLocalidadId(String localidadId);

	List<Localidad> obtenerLocalidadesPorProvinciaId(Vigencia baja, String id) throws AplicException;


}
