package de.beyondjava.dominio.modelo;

public enum Vigencia {
	NO_ACTIVO("d", "No activo"), ACTIVO("a", "Activo"), BAJA("b", "Baja");

	private String vigenciaId;
	private String descripcion;

	private Vigencia(String vigenciaId, String descripcion) {
		this.vigenciaId = vigenciaId;
		this.descripcion = descripcion;
	}

	public String getVigenciaId() {
		return vigenciaId;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public static Vigencia parse(String id) {
		Vigencia vigencia = null;
		// Default
		for (Vigencia item : Vigencia.values()) {
			if (item.getVigenciaId().compareTo(id)==0) {
				vigencia = item;
				break;
			}
		}
		return vigencia;
	}
}
