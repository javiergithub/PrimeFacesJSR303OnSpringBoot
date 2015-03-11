package de.beyondjava.jsf.sample.searchExpressions.bean;

public class AccionMap {
	private static java.util.Map<Integer, Accion> table = new java.util.HashMap<Integer, Accion>();
	private static java.util.Map<String, Accion> tableInversa = new java.util.HashMap<String, Accion>();
	static {
		for (Accion accion : Accion.values()) {
			if (accion.compareTo(Accion.CREA)==0){
				table.put(new Integer(1), accion);
				tableInversa.put(Accion.CREA.getAccion().toLowerCase(), accion);
			} else if (accion.compareTo(Accion.ACTUALIZA)==0){
				table.put(new Integer(2), accion);
				tableInversa.put(Accion.ACTUALIZA.getAccion().toLowerCase(), accion);
			} else if (accion.compareTo(Accion.ELIMINA)==0){
				table.put(new Integer(3), accion);
				tableInversa.put(Accion.ELIMINA.getAccion().toLowerCase(), accion);
			} else if (accion.compareTo(Accion.VER)==0){
				table.put(new Integer(4), accion);
				tableInversa.put(Accion.VER.getAccion().toLowerCase(), accion);
			} else if (accion.compareTo(Accion.BLOQUEAR)==0){
				table.put(new Integer(5), accion);
				tableInversa.put(Accion.BLOQUEAR.getAccion().toLowerCase(), accion);
			} else if (accion.compareTo(Accion.DESBLOQUEAR)==0){
				table.put(new Integer(6), accion);
				tableInversa.put(Accion.DESBLOQUEAR.getAccion().toLowerCase(), accion);
			} else if (accion.compareTo(Accion.RESETEAR_PASSWORD)==0){
				table.put(new Integer(7), accion);
				tableInversa.put(Accion.RESETEAR_PASSWORD.getAccion().toLowerCase(), accion);
			} else if (accion.compareTo(Accion.CAMBIAR_PASSWORD)==0){
				table.put(new Integer(8), accion);
				tableInversa.put(Accion.CAMBIAR_PASSWORD.getAccion().toLowerCase(), accion);
			} else if (accion.compareTo(Accion.GENERA_CARNET)==0){
				table.put(new Integer(9), accion);
				tableInversa.put(Accion.GENERA_CARNET.getAccion().toLowerCase(), accion);
			}else table.put(10, accion);
		}
	}

	public static Accion valueOf(Integer i) {
		return table.get(i);
	}
	public static Accion valueInverseOf(String accion) {
		return tableInversa.get(accion);
	}


}
