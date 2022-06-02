package org.uem.gestor_resultados_eurovision.contract;

public enum ResultadoContract {
	PAIS,
	CANCION,
	INTERPRETE,
	PUNTOS_JURADO,
	PUNTOS_PUBLICO,
	PUNTOS;
	
	public static String[] getAllCols() {
		ResultadoContract[] resultContractVals = ResultadoContract.values();
		String[] cols = new String[resultContractVals.length - 1];
		for (int i = 0; i < resultContractVals.length - 1; i++) {
			cols[i] = resultContractVals[i].toString(); 
		}
		return cols;
	}
	
	public static String[] getTableCols() { // columnas de gui
		String[] cols = new String[4];
		cols[0] = ResultadoContract.PAIS.toString();
		cols[1] = ResultadoContract.CANCION.toString();
		cols[2] = ResultadoContract.INTERPRETE.toString();
		cols[3] = ResultadoContract.PUNTOS.toString();
		return cols;
	}
}
