package de.beyondjava.dominio.excepcion;

import java.io.Serializable;

public class PrestadoresClaveNaturalDataExcepcion extends RuntimeException implements Serializable {
	String mensaje = "Ingreso duplicado para: ";
	String campo;
	String valor;
	
	public PrestadoresClaveNaturalDataExcepcion() {
		super();
	}
	public PrestadoresClaveNaturalDataExcepcion(String mensaje) {
		super(mensaje);
		this.mensaje = mensaje;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getCampo() {
		return campo;
	}
	public void setCampo(String campo) {
		this.campo = campo;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return mensaje.concat(campo).concat("=").concat(valor);
	}
	
	
}