package de.beyondjava.dominio.modelo;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Persona implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String nombre;

	@Column(nullable = false)
	private Provincia provincia;

	@Column(nullable = false)
	private Localidad localidad;

	protected Persona() {
	}

	public Persona(String nombre, Provincia provincia, Localidad localidad) {
		this.nombre = nombre;
		this.provincia = provincia;
		this.localidad = localidad;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Provincia getProvincia() {
		return this.provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public Localidad getLocalidad() {
		return this.localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}


}
