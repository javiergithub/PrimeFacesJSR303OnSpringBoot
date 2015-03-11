package de.beyondjava.jsf.sample.searchExpressions.bean;

public enum Accion {
	CREA (1,"Crea"),
	ACTUALIZA (2,"Actualiza"),
	ELIMINA (3,"Elimina"),
	VER (4,"Ver"),
	BLOQUEAR (5,"Bloquea"),
	DESBLOQUEAR (6,"Desbloquea"), 
	RESETEAR_PASSWORD (7,"Resetea"), 
	CAMBIAR_PASSWORD (8,"Cambia"), GENERA_CARNET (9,"Genera Carnet");

	private final int id;
	private final String accion;
	
	Accion(int id, String accion){
		this.id = id;
		this.accion = accion;
	}

	public int getId() {
		return id;
	}

	public String getAccion() {
		return accion;
	}
}
