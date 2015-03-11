package de.beyondjava.jsf.sample.searchExpressions.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RestController;

import de.beyondjava.dominio.excepcion.AplicException;
import de.beyondjava.dominio.modelo.Localidad;
import de.beyondjava.dominio.reporte.CriterioBusquedaLocalidad;
import de.beyondjava.dominio.reporte.SelConsultaLocalidadesReporte;
import de.beyondjava.dominio.servicio.ServicioConfiguracion;



@RestController("localidadTablaBack")
@Scope("view")
public class LocalidadTablaBean implements Serializable{
	private static final long serialVersionUID = 1L;

	private LazyDataModel<SelConsultaLocalidadesReporte> modeloPerezoso;

	private SelConsultaLocalidadesReporte localidadesSeleccionado;
	private Localidad localidad;
	private CriterioBusquedaBean criterioBusqueda;
	//@ManagedProperty(value = "#{servicioConfiguracion}")
	@Autowired
	protected ServicioConfiguracion servicioConfiguracion;
	private boolean mostrarTabla;
	private boolean mostrarLocalidad = false;
	private boolean disabledlocalidad = false;
	private boolean vista;
	private boolean periodo;
	
	public LocalidadTablaBean() {
		criterioBusqueda = new CriterioBusquedaBean();
		criterioBusqueda.setCriterioBusquedaLocalidad(new CriterioBusquedaLocalidad());
	}

	public SelConsultaLocalidadesReporte getLocalidadSeleccionado() {
		return localidadesSeleccionado;
	}

	public void setLocalidadSeleccionado(SelConsultaLocalidadesReporte localidadSeleccionado) {
		this.localidadesSeleccionado = localidadSeleccionado;
	}
	
	public LazyDataModel<SelConsultaLocalidadesReporte> getModeloPerezoso() {
		return modeloPerezoso;
	}

	public CriterioBusquedaBean getCriterioBusqueda() {
		return criterioBusqueda;
	}

	public void setCriterioBusqueda(CriterioBusquedaBean criterioBusqueda) {
		this.criterioBusqueda = criterioBusqueda;
	}

	public ServicioConfiguracion getServicioConfiguracion() {
		return servicioConfiguracion;
	}

	public void setServicioConfiguracion(ServicioConfiguracion servicioConfiguracion) {
		this.servicioConfiguracion = servicioConfiguracion;
	}

	@SuppressWarnings("serial")
	public void obtenerLocalidad(ActionEvent actionEvent) {
		modeloPerezoso = new LazyDataModel<SelConsultaLocalidadesReporte>() {

			@Override
			public List<SelConsultaLocalidadesReporte> load(int first, int pageSize, String sortField, 
					SortOrder sortOrder, Map<String,Object> filters) {
				criterioBusqueda.setPagina(first);
				criterioBusqueda.setTamanioPagina(pageSize);
				List<SelConsultaLocalidadesReporte> selConsultaLocalidadReportes = new ArrayList<SelConsultaLocalidadesReporte>();
				try {
					selConsultaLocalidadReportes = servicioConfiguracion.obtenerLocalidadesCriterioBusquedaPaginada(
							criterioBusqueda.getCriterioBusquedaLocalidad(), criterioBusqueda.getPagina(),
							criterioBusqueda.getTamanioPagina());
				} catch (AplicException e) {
					e.printStackTrace();
				}
				return selConsultaLocalidadReportes;
			}

		};

		try {
			modeloPerezoso.setRowCount(servicioConfiguracion
					.obtenerLocalidadesCriterioBusquedaTotal(criterioBusqueda.getCriterioBusquedaLocalidad()));
		} catch (AplicException e) {
			e.printStackTrace();
		}
	}


	public boolean isMostrarTabla() {
		return mostrarTabla;
	}

	public void setMostrarTabla(boolean mostrarTabla) {
		this.mostrarTabla = mostrarTabla;
		if (criterioBusqueda.isSumarizado()==true) this.mostrarTabla=false;
	}

	public void setResetearModelo(String valor){
		if (valor.compareTo("null")==0)
			this.modeloPerezoso.setRowCount(0);
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}


	public boolean isMostrarLocalidad() {
		return mostrarLocalidad;
	}

	public void setMostrarLocalidad(boolean mostrarLocalidad) {
		this.mostrarLocalidad = mostrarLocalidad;
	}

	public boolean getVista() {
		return vista;
	}

	public void setVista(boolean vista) {
		this.vista = vista;
	}

	public boolean isPeriodo() {
		return periodo;
	}

	public void setPeriodo(boolean periodo) {
		this.periodo = periodo;
	}

	public boolean isDisabledlocalidad() {
		return disabledlocalidad;
	}

	public void setDisabledLocalidad(boolean disabledLocalidad) {
		this.disabledlocalidad = disabledLocalidad;
	}


}
