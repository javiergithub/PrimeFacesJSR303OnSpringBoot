package de.beyondjava.dominio.modelo;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Localidad implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String nombre;

	@Column(nullable = false)
	private Provincia provincia;

	protected Localidad() {
	}

	public Localidad(String nombre, Provincia provincia) {
		this.nombre = nombre;
		this.provincia = provincia;
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


}
