package de.beyondjava.dominio.modelo;

import java.io.Serializable;
import javax.persistence.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
public class Provincia implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String nombre;

	protected Provincia() {
	}

	public Provincia(String nombre) {
		this.nombre = nombre;
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
	
	public boolean equals(Object value) {
		if (this == value) {
			return true;
		}
		if (value instanceof Provincia == false)
			return false;
		Provincia rhs = (Provincia) value;
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
