package de.beyondjava.jsf.sample.searchExpressions.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import de.beyondjava.dominio.modelo.Provincia;
import de.beyondjava.dominio.servicio.ServicioProvincia;
import de.beyondjava.jsf.sample.searchExpressions.utils.FacesUtils;


@Component("provinciaConverter")
public class ProvinciaConverter  implements Converter{

	@Autowired
	private ServicioProvincia servicioProvincia;
	
	public ProvinciaConverter(){
//		servicioProvincia=(ServicioProvincia) FacesUtils.getManagedBean("servicioProvincia");
	}
	
	public Object getAsObject(FacesContext context, UIComponent componente, String nuevoValor) {
		if (nuevoValor == null || nuevoValor.isEmpty()) return nuevoValor;
		try{
			return servicioProvincia.obtenerProvinciaId(Long.valueOf(nuevoValor));
		}catch(NumberFormatException e){ // Value isn't a long and thus not an id.
		    return null;
		}
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object nuevoObject) {
		if (nuevoObject == null
				|| !(nuevoObject instanceof Provincia)) return null;
		return ((Provincia) nuevoObject).getId().toString();
	}

	public ServicioProvincia getServicioProvincia() {
		return servicioProvincia;
	}

	public void setServicioProvincia(ServicioProvincia servicioProvincia) {
		this.servicioProvincia = servicioProvincia;
	}

}
