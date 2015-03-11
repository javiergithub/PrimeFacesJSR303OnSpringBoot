package de.beyondjava.dominio.servicio.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.beyondjava.dominio.dao.LocalidadRepository;
import de.beyondjava.dominio.excepcion.AplicException;
import de.beyondjava.dominio.excepcion.PrestadoresClaveNaturalDataExcepcion;
import de.beyondjava.dominio.modelo.Localidad;
import de.beyondjava.dominio.modelo.Vigencia;
import de.beyondjava.dominio.reporte.CriterioBusquedaLocalidad;
import de.beyondjava.dominio.reporte.SelConsultaLocalidadesReporte;
import de.beyondjava.dominio.servicio.ServicioConfiguracion;


@Service(value="servicioConfiguracion")
public class ServicioConfiguracionImpl implements ServicioConfiguracion, Serializable {
	
	private static final long serialVersionUID = 1L;

	@Autowired
	private LocalidadRepository localidadRepository;

	@Override
	public List<Localidad> obtenerLocalidades(Vigencia baja)
			throws AplicException {
		return localidadRepository.findAll();
	}

	
	@Override
	public Localidad obtenerLocalidadId(String valueOf) {
		return localidadRepository.findOne(Long.valueOf(valueOf));
	}

	@Override
	public List<Localidad> obtenerLocalidadesPorProvinciaId(Vigencia baja,
			String id) throws AplicException {
		return localidadRepository.findByProvinciaId(Long.valueOf(id));
	}

		@Override
	public void guardarLocalidad(Localidad localidad)
			throws PrestadoresClaveNaturalDataExcepcion {
				try {
					localidadRepository.save(localidad);
				} catch (PersistenceException e) {
					if (e.getCause() instanceof ConstraintViolationException) {
						PrestadoresClaveNaturalDataExcepcion prestadoresClaveNaturalDataExcepcion = new PrestadoresClaveNaturalDataExcepcion();
						prestadoresClaveNaturalDataExcepcion.setCampo("nombre");
						prestadoresClaveNaturalDataExcepcion.setValor(localidad
								.getNombre());
						throw prestadoresClaveNaturalDataExcepcion;
					}
				}
			}

	@Override
	public void actualizarLocalidad(Localidad localidad)
			throws PrestadoresClaveNaturalDataExcepcion {
		try {
			localidadRepository.save(localidad);
		} catch (PersistenceException e) {
			if (e.getCause() instanceof ConstraintViolationException) {
				PrestadoresClaveNaturalDataExcepcion prestadoresClaveNaturalDataExcepcion = new PrestadoresClaveNaturalDataExcepcion();
				prestadoresClaveNaturalDataExcepcion.setCampo("nombre");
				prestadoresClaveNaturalDataExcepcion.setValor(localidad
						.getNombre());
				throw prestadoresClaveNaturalDataExcepcion;
			}
		}
	}

	

	@Override
	public List<SelConsultaLocalidadesReporte> obtenerLocalidadesCriterioBusquedaPaginada(
			CriterioBusquedaLocalidad criterioBusquedaLocalidad,
			int pagina, int tamanioPagina) throws AplicException{
		return localidadRepository.obtenerLocalidadesCriterioBusquedaPaginada(
				criterioBusquedaLocalidad,
				pagina, tamanioPagina);
	}

	@Override
	public int obtenerLocalidadesCriterioBusquedaTotal(
			CriterioBusquedaLocalidad criterioBusquedaLocalidad) throws AplicException {
		return localidadRepository.obtenerLocalidadesCriterioBusquedaTotal(
				 criterioBusquedaLocalidad);
	}

	@Override
	public Localidad obtenerLocalidadCompleto(String localidadId) {
		return localidadRepository.findOne(Long.valueOf(localidadId));
	}


}
