package de.beyondjava.jsf.sample.searchExpressions.bean;

import java.io.Serializable;
import java.lang.reflect.Method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RestController;

import de.beyondjava.dominio.excepcion.AplicException;
import de.beyondjava.dominio.excepcion.PrestadoresClaveNaturalDataExcepcion;
import de.beyondjava.dominio.modelo.Localidad;
import de.beyondjava.dominio.servicio.ServicioConfiguracion;
import de.beyondjava.jsf.sample.searchExpressions.utils.FacesUtils;

@RestController("localidadBack")
@Scope("view")
public class LocalidadBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private Localidad localidad;
	private String localidadId;
	private boolean deshabilitado = true;
	private String accion = null;
	private Method operacion;
	@Autowired
	protected ServicioConfiguracion servicioConfiguracion;

	public LocalidadBean() {
		super();
	}

	public String getCargarLocalidad() throws AplicException   {
		try {
			getConsultaLocalidad();
			if (accion == null) {
				throw new AplicException("error");
			}
		} catch (SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NoSuchMethodException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Accion accionMap = AccionMap.valueInverseOf(accion.toLowerCase());
		if (accionMap == null) {
			throw new AplicException("error");
		}
		switch (accionMap) {
		case CREA:
			deshabilitado = false;
			nuevoLocalidad();
			break;
		case ACTUALIZA:
			deshabilitado = false;
			iniciarLocalidad();
			break;
		case ELIMINA:
		case VER:
			deshabilitado = true;
			iniciarLocalidad();
			break;
		default:
			throw new AplicException("error");
		}
		return null;
	}

	public String getConsultaLocalidad() throws SecurityException,
			NoSuchMethodException {
		if (accion == null)
			accion = FacesUtils.getRequestParameter("accion");
		return null;
	}

	private void nuevoLocalidad() {
		if (localidad == null) {
			localidad = new Localidad();
/*			Activa activa = new Activa(Vigencia.ACTIVO);
			localidad.setActiva(activa);*/
		}
	}

	private void iniciarLocalidad() throws AplicException {
		if (localidadId == null) {
//			localidadId = Long.valueOf(FacesUtils.getRequestParameter("localidadId"));
			if (localidadId == null)
				throw new AplicException("error");
			else if (FacesUtils.getRequestParametersTotal() != 2)
				throw new AplicException("error");
		}
		localidad = servicioConfiguracion
				.obtenerLocalidadCompleto(localidadId);
		if (localidad == null
				/*|| (localidad != null && localidad.getActiva()
						.getVigenciaId()
						.compareTo(Vigencia.BAJA.getVigenciaId()) == 0)*/) {
			throw new AplicException("error");
		}

	}


	public boolean isDeshabilitado() {
		return deshabilitado;
	}

	public void setDeshabilitado(boolean deshabilitado) {
		this.deshabilitado = deshabilitado;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public ServicioConfiguracion getServicioConfiguracion() {
		return servicioConfiguracion;
	}

	public void setServicioConfiguracion(
			ServicioConfiguracion servicioConfiguracion) {
		this.servicioConfiguracion = servicioConfiguracion;
	}



	public String invocar() {
		String navega = "/vistas/home.jsf";
		Accion accionMap = AccionMap.valueInverseOf(accion.toLowerCase());
		switch (accionMap) {
		case CREA:
			navega = this.guardarLocalidad();
			break;
		case ACTUALIZA:
			navega = this.actualizarLocalidad();
			break;
		
		case VER:
			navega = this.consultarLocalidad();
			break;
		default:
			break;
		}
		return navega;
	}

	private String consultarLocalidad() {
		servicioConfiguracion.obtenerLocalidadId(localidadId);
		return "/vistas/home.jsf?faces-redirect=true";
	}

	public String guardarLocalidad() {
		try {
			localidad.setId(null);
			servicioConfiguracion.guardarLocalidad(localidad);
		} catch (PrestadoresClaveNaturalDataExcepcion e) {
			FacesUtils.addErrorMessage(e.toString());
			return null;
		}
		return "/vistas/home.jsf?faces-redirect=true";
	}

	private String actualizarLocalidad() {
		try {
			servicioConfiguracion.actualizarLocalidad(localidad);
		} catch (PrestadoresClaveNaturalDataExcepcion e) {
			FacesUtils.addErrorMessage(e.toString());
			return null;
		}
		return "/vistas/home.jsf?faces-redirect=true";
	}

	

	public Method operacion() {
		return operacion;
	}

	public void operacion(Method operacion) {
		this.operacion = operacion;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	public String getLocalidadId() {
		return localidadId;
	}

	public void setLocalidadId(String localidadId) {
		this.localidadId = localidadId;
	}
}
