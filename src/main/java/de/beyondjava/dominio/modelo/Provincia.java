package de.beyondjava.dominio.modelo;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Provincia implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String nombre;

	protected Provincia() {
	}

	public Provincia(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
