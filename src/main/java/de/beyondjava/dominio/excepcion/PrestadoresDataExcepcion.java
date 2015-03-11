package de.beyondjava.dominio.excepcion;

import org.springframework.dao.DataAccessException;

public class PrestadoresDataExcepcion extends RuntimeException {

	String mensaje;
	public PrestadoresDataExcepcion(String mensaje) {
		super(mensaje);
		this.mensaje = mensaje;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
