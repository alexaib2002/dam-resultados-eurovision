package org.uem.gestor_resultados_eurovision.model;

import java.util.ArrayList;

public record Resultado(
		int pos, 
		String pais, 
		String cancion, 
		String interprete, 
		int pts) {
	public ArrayList<String> toStringArray() {
		ArrayList<String> vals = new ArrayList<>();
		vals.add(Integer.toString(pos));
		vals.add(pais);
		vals.add(cancion);
		vals.add(interprete);
		vals.add(Integer.toString(pts));
		return vals;
	}
}
