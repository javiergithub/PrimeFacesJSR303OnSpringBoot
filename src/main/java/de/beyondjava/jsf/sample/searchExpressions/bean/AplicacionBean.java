package de.beyondjava.jsf.sample.searchExpressions.bean;


import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.PostConstruct;
import javax.faces.FacesException;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.SelectItem;

import de.beyondjava.dominio.excepcion.AplicException;
import de.beyondjava.dominio.modelo.Provincia;
import de.beyondjava.dominio.modelo.Vigencia;
import de.beyondjava.dominio.servicio.ServicioConfiguracion;
import de.beyondjava.dominio.servicio.ServicioProvincia;
import de.beyondjava.jsf.sample.searchExpressions.utils.SeleccionVaciaEnum;


@ManagedBean(name="aplicacionBack",eager=true)
@ApplicationScoped
public class AplicacionBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<Vigencia> vigencias;
	private List<SelectItem> provinciasList = new ArrayList<SelectItem>();
	private List<SelectItem> tiposDocumentoList = new ArrayList<SelectItem>();
	@ManagedProperty(value = "#{servicioConfiguracion}")
	private ServicioConfiguracion servicioConfiguracion;
	@ManagedProperty(value = "#{servicioProvincia}")
	private ServicioProvincia servicioProvincia;
    private Map<String, String> themes;  
    
    private SelectItem seleccionVacia;
    private static Date fechaInicioOperaciones=null;
	
	static {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.set(Calendar.YEAR, 2012);
		calendar.set(Calendar.MONTH, 9);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		fechaInicioOperaciones= calendar.getTime();
	}
	public AplicacionBean(){
		super();
		vigencias = new ArrayList<Vigencia>();
		provinciasList = new ArrayList<SelectItem>();
		tiposDocumentoList = new ArrayList<SelectItem>();
		themes = new TreeMap<String, String>();
		seleccionVacia = null;
	}
	
	@PostConstruct
	protected void init2() {
		setVigencias();
		setProvinciasList();
		setThemes();
		setSeleccionVacia();
	}
	
	// Vigencias
	public List<Vigencia> getVigencias() {
		if (vigencias.size() == 0) {
			setVigencias();
		}
		return (vigencias);
	}

	public void setVigencias() {
		vigencias = new ArrayList<Vigencia>();

		vigencias.add(Vigencia.ACTIVO);
		vigencias.add(Vigencia.NO_ACTIVO);
	}

	public void resetVigencias(ActionEvent event){
		this.vigencias = new ArrayList<Vigencia>();
	}

	
	public ServicioConfiguracion getServicioConfiguracion() {
		return servicioConfiguracion;
	}

	public void setServicioConfiguracion(ServicioConfiguracion servicioConfiguracion) {
		this.servicioConfiguracion = servicioConfiguracion;
	}
	
	// Themes
	public Map<String, String> getThemes(){
		if (themes == null || themes.isEmpty()) {
			setThemes();
		}
		return (themes);
	}
	
	public void setThemes() {
		themes = new TreeMap<String, String>();
        themes.put("Black-Tie", "black-tie");  
        themes.put("Blitzer", "blitzer");  
        themes.put("Bluesky", "bluesky");  
        themes.put("Casablanca", "casablanca");  
        themes.put("Cupertino", "cupertino");  
        themes.put("Dark-Hive", "dark-hive");  
        themes.put("Dot-Luv", "dot-luv");  
        themes.put("Eggplant", "eggplant");  
        themes.put("Excite-Bike", "excite-bike");  
        themes.put("Flick", "flick");  
        themes.put("Glass-X", "glass-x");  
        themes.put("Hot-Sneaks", "hot-sneaks");  
        themes.put("Humanity", "humanity");  
        themes.put("Le-Frog", "le-frog");  
        themes.put("Midnight", "midnight");  
        themes.put("Mint-Choc", "mint-choc");  
        themes.put("Overcast", "overcast");  
        themes.put("Pepper-Grinder", "pepper-grinder");  
        themes.put("Redmond", "redmond");  
        themes.put("Rocket", "rocket");  
        themes.put("Sam", "sam");  
        themes.put("Smoothness", "smoothness");  
        themes.put("South-Street", "south-street");  
        themes.put("Start", "start");  
        themes.put("Sunny", "sunny");  
        themes.put("Swanky-Purse", "swanky-purse");  
        themes.put("Trontastic", "trontastic");  
        themes.put("UI-Lightness", "ui-lightness");  
        themes.put("Vader", "vader");  	
     }

	//  Selleccion Vacia SelectItem
	public SelectItem getSeleccionVacia(){
		if (seleccionVacia == null) {
			setSeleccionVacia();
		}
		return (seleccionVacia);
	}
	
	public void setSeleccionVacia(){
		seleccionVacia = new SelectItem(SeleccionVaciaEnum.SELECCIONEUNO.getValor(),
				SeleccionVaciaEnum.SELECCIONEUNO.getNombre());
	}
	
	//Provincias
	public List<SelectItem> getProvinciasList() {
		if (provinciasList.size() == 0) {
			setProvinciasList();
		}
		return (provinciasList);
	}

	public void setProvinciasList() {
		provinciasList = new ArrayList<SelectItem>();

		try {
			List<Provincia> provinciaL = servicioProvincia.findAll();
			SelectItem item = null;
			for (Provincia provinciaItem:provinciaL){
				item = new SelectItem(provinciaItem.getId(), provinciaItem.getNombre());
				provinciasList.add(item);
			}
		} catch (AplicException ce) {
			String msg = "Error al recuperar datos de la tabla Provincia";
			throw new FacesException(msg, ce);
		}
	}

	public void resetProvinciasList(ActionEvent event){
		this.provinciasList = new ArrayList<SelectItem>();
	}
	
	
	public Date getHoy(){
		return new Date();
	}

	public static Date getFechaInicioOperaciones(){
		return fechaInicioOperaciones;
	}

	public ServicioProvincia getServicioProvincia() {
		return servicioProvincia;
	}

	public void setServicioProvincia(ServicioProvincia servicioProvincia) {
		this.servicioProvincia = servicioProvincia;
	}

	
}
