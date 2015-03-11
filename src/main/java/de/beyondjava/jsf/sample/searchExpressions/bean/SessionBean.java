package de.beyondjava.jsf.sample.searchExpressions.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import org.springframework.context.annotation.Scope;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope("session")
public class SessionBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private MenuModel model;

	private void menu() {
		model = new DefaultMenuModel();

		// Administrar Menu
		DefaultSubMenu submenuAdministrarRoot = new DefaultSubMenu();
		submenuAdministrarRoot.setLabel("Administrar");
		submenuAdministrarRoot.setId("administrarMenu");

		// Configuracion submenu
		DefaultSubMenu submenuConfiguracionAdministrar = new DefaultSubMenu();
		submenuConfiguracionAdministrar.setLabel("Configuración");
		submenuConfiguracionAdministrar.setId("configuraSubMenu");
		
		
		DefaultSubMenu submenuObraSocialConfiguracion = crearElemento(
				"Configura", "Localidad", true);
		submenuObraSocialConfiguracion.setLabel("Localidad");
		submenuConfiguracionAdministrar.addElement(submenuObraSocialConfiguracion);
		submenuAdministrarRoot.addElement(submenuConfiguracionAdministrar);

		model.addElement(submenuAdministrarRoot);
	}
	
	private DefaultSubMenu crearElemento(String ancestro, String entidad,
			boolean principales, Object[]... acciones) {
		entidad = StringUtils.uncapitalize(entidad);
		ancestro = StringUtils.uncapitalize(ancestro);
		String entidadCapitalize = StringUtils.capitalize(entidad);
		String ancestroCapitalize = StringUtils.capitalize(ancestro);
		DefaultMenuItem item = null;
		DefaultSubMenu submenuEntidad = new DefaultSubMenu();
		submenuEntidad.setId(entidad + ancestroCapitalize + "SubMenu");

		if (isFuncion(31) == true) {
			item = new DefaultMenuItem();
			item.setValue("Crear");
			item.setId("crear" + entidadCapitalize + ancestroCapitalize
					+ "ItemSubMenu");
			item.setUrl("/vistas/" + ancestro + "/" + entidad.toLowerCase()
					+ "/" + StringUtils.uncapitalize(entidadCapitalize)
					+ ".xhtml?accion=" + Accion.CREA.getAccion());
			submenuEntidad.addElement(item);
		}
		if (isFuncion(31) == true) {
			item = new DefaultMenuItem();
			item.setId("modificar" + entidadCapitalize + ancestroCapitalize
					+ "ItemSubMenu");
			item.setValue("Modificar");
			item.setUrl("/vistas/" + ancestro + "/" + entidad.toLowerCase()
					+ "/consulta/consulta" + entidadCapitalize
					+ ".xhtml?accion=" + Accion.ACTUALIZA.getAccion());
			submenuEntidad.addElement(item);
		}
		if (isFuncion(31) == true) {
			item = new DefaultMenuItem();
			item.setId("eliminar" + entidadCapitalize + ancestroCapitalize
					+ "ItemSubMenu");
			item.setValue("Eliminar");
			item.setUrl("/vistas/" + ancestro + "/" + entidad.toLowerCase()
					+ "/consulta/consulta" + entidadCapitalize
					+ ".xhtml?accion=" + Accion.ELIMINA.getAccion());
			submenuEntidad.addElement(item);
		}
		if (isFuncion(31) == true) {
			item = new DefaultMenuItem();
			item.setId("ver" + entidadCapitalize + ancestroCapitalize
					+ "ItemSubMenu");
			item.setValue("Ver");
			item.setUrl("/vistas/" + ancestro + "/" + entidad.toLowerCase()
					+ "/consulta/consulta" + entidadCapitalize
					+ ".xhtml?accion=" + Accion.VER.getAccion());
			submenuEntidad.addElement(item);
		}
		return submenuEntidad;

	}
	
	public boolean isFuncion(int funcion) {
		return true;
	}

	public MenuModel getModel() {
		if (model == null)
			menu();
		return model;
	}

	public void setModel(MenuModel model) {
		this.model = model;
	}
}
