package de.beyondjava.jsf.sample.searchExpressions.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import de.beyondjava.dominio.modelo.Localidad;
import de.beyondjava.dominio.servicio.ServicioConfiguracion;
import de.beyondjava.jsf.sample.searchExpressions.utils.FacesUtils;
import de.beyondjava.jsf.sample.searchExpressions.utils.SeleccionVaciaEnum;


@FacesConverter("localidadConverter")
public class LocalidadConverter implements Converter{

	private ServicioConfiguracion servicioConfiguracion;
	

	public LocalidadConverter() {
		super();
		servicioConfiguracion=(ServicioConfiguracion) FacesUtils.getManagedBean("servicioConfiguracion");

	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent componente, String nuevoValor) {
		if (nuevoValor == null || nuevoValor.isEmpty() || 
				nuevoValor.compareTo(SeleccionVaciaEnum.SELECCIONEUNO.getNombre())==0) 
			return SeleccionVaciaEnum.SELECCIONEUNO.getValor();
		Localidad localidad=servicioConfiguracion.obtenerLocalidadId(String.valueOf(nuevoValor));
		return localidad;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object nuevoObject) {
		if (nuevoObject == null  
				|| !(nuevoObject instanceof Localidad) || ((Localidad) nuevoObject).getId() == null) return null;
		return ((Localidad) nuevoObject).getId().toString();
	}

	public ServicioConfiguracion getServicioConfiguracion() {
		return servicioConfiguracion;
	}

	public void setServicioConfiguracion(ServicioConfiguracion servicioConfiguracion) {
		this.servicioConfiguracion = servicioConfiguracion;
	}

}
