/*
 * Proyecto SNR
 */
package de.beyondjava.jsf.sample.searchExpressions.utils;

import java.io.Serializable;

import javax.el.ValueExpression;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.webapp.UIComponentTag;
import javax.servlet.ServletContext;


@SuppressWarnings({"serial"})
public class FacesUtils implements Serializable{
	public static ServletContext getServletContext() {
		return (ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext();
	}
	
	public static Object getManagedBean(String beanName) {
		FacesContext context = FacesContext.getCurrentInstance();
		Object o = getValueBinding(getJsfEl(beanName)).getValue(context.getELContext());
		
		return o;
	}  
	
	public static void resetManagedBean(String beanName) {
		FacesContext context = FacesContext.getCurrentInstance();
		getValueBinding(getJsfEl(beanName)).setValue(context.getELContext(), null);
	}
	
	public static void setManagedBeanInSession(String beanName, Object managedBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(beanName, managedBean);
	}
	
	public static String getRequestParameter(String name) {
		return (String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(name);
	}
	
	public static void addInfoMessage(String msg) {
		addInfoMessage(null, msg);
	}
	
	public static void addInfoMessage(String clientId, String msg) {
		FacesContext.getCurrentInstance().addMessage(clientId, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
	}
	
	public static void addErrorMessage(String msg) {
		addErrorMessage(null, msg);
	}
	
	public static void addErrorMessage(String clientId, String msg) {
		FacesContext.getCurrentInstance().addMessage(clientId, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
	}
	
	public static Integer evalInt(String el) {
		if (el == null) {
			return null;
		}
		
		if (UIComponentTag.isValueReference(el)) {
			Object value = getElValue(el);
			
			if (value == null) {
				return null;
			}
			else if (value instanceof Integer) {
				return (Integer)value;
			}
			else {
				return new Integer(value.toString());
			}
		}
		else {
			return new Integer(el);
		}
	}
	
	private static ValueExpression getValueBinding(String el) {
		FacesContext context = FacesContext.getCurrentInstance();
		return context.getApplication()
			.getExpressionFactory().createValueExpression(context.getELContext(), el, // name is your bean name
					Object.class );
	}
	
	private static Object getElValue(String el) {
		FacesContext context = FacesContext.getCurrentInstance();
		return getValueBinding(el).getValue(context.getELContext());
	}
	
	private static String getJsfEl(String value) {
		return "#{" + value + "}";
	}

	public static int getRequestParametersTotal() {
		return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().size();
	}
}
