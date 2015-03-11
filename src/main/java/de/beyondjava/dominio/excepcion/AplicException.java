package de.beyondjava.dominio.excepcion;

import java.io.Serializable;

public class AplicException extends Exception implements Serializable {

	private String mensaje;
	public AplicException(String mensaje) {
		super();
		this.mensaje = mensaje;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	

}
