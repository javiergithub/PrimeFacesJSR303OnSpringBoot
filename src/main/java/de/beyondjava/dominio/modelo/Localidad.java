package de.beyondjava.dominio.modelo;

import java.io.Serializable;

import javax.persistence.*;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
public class Localidad implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String nombre;

	private Provincia provincia;

	public Localidad() {
	}

	public Localidad(String nombre, Provincia provincia) {
		this.nombre = nombre;
		this.provincia = provincia;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(nullable = false)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@ManyToOne
	@JoinColumn(name="provincia_id")
	public Provincia getProvincia() {
		return this.provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public boolean equals(Object value) {
		if (this == value) {
			return true;
		}
		if (value instanceof Localidad == false)
			return false;
		Localidad rhs = (Localidad) value;
		EqualsBuilder eq= new EqualsBuilder().append(nombre, rhs.nombre);
		return eq.isEquals();
	}

	public int hashCode() {
		HashCodeBuilder hc = new HashCodeBuilder(17, 37).append(nombre);
		return hc.toHashCode();
	}

	public String toString() {
		ToStringBuilder tsb = new ToStringBuilder(this).append("nombre", nombre);
		return tsb.toString();
	}
	

}
