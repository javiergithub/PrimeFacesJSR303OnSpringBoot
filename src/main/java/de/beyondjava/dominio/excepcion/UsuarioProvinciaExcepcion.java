package de.beyondjava.dominio.excepcion;

import org.springframework.dao.DataAccessException;

public class UsuarioProvinciaExcepcion extends RuntimeException {

	String mensaje;
	public UsuarioProvinciaExcepcion(String mensaje) {
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
