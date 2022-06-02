package org.uem.gestor_resultados_eurovision.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;

import javax.swing.JComponent;
import javax.swing.JSpinner;

import org.uem.gestor_resultados_eurovision.contract.ResultadoContract;
import org.uem.gestor_resultados_eurovision.contract.TableContract;
import org.uem.gestor_resultados_eurovision.persist.DBPersistence;
import org.uem.gestor_resultados_eurovision.utils.SQLQueryBuilder;
import org.uem.gestor_resultados_eurovision.utils.WindowActionUtils;
import org.uem.gestor_resultados_eurovision.view.MainFrame;
import org.uem.gestor_resultados_eurovision.view.submenus.ConsultaPanel;
import org.uem.gestor_resultados_eurovision.view.submenus.RegistroPanel;

public class MainController implements ActionListener {

	private MainFrame mainFrame;
	private DBPersistence persistence;
	private WindowAdapter winAdapter;
	
	public MainController(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		this.persistence = new DBPersistence();
		this.winAdapter = new WindowAdapter() {
			// sobreescribir metodo llamado al cerrar aplicacion desde sistema operativo
			@Override
			public void windowClosing(WindowEvent e) {
				WindowActionUtils.onExitEvent(mainFrame);
			}			
		};
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String action = event.getActionCommand().toLowerCase();
		String callerID = ((String) ((JComponent) event.getSource()).getClientProperty("CallerID"));
		if (callerID != null) { // there's a source type attached, so we can filter the caller
			parseCallerIDAction(callerID, action);
		} else {
			throw new IllegalArgumentException(String.format("El evento %s no tiene ningun callerID asignado", callerID));
		}
	}
	
	public DBPersistence getPersistence() {
		return persistence;
	}
	
	public WindowAdapter getWinAdapter() {
		return winAdapter;
	}
	
	private void parseCallerIDAction(String callerID, String action) {
		switch (callerID) {
		case "mainView": {
			switchMainAction(action);
			break;
		}
		case "registroPanel": {
			switchRegistroAction(action);
			break;
		}
		default:
			throw new IllegalArgumentException("Unnasinged caller ID: " + callerID);
		}
	}
	
	private void switchMainAction(String action) {
		switch (action) {
		case "consulta de resultados": {
			ConsultaPanel consultaPanel = mainFrame.getConsultaPanel();
			consultaPanel.updateTable(getPersistence().getResultadosList());
			mainFrame.setContentSubmenu(consultaPanel);
			break;
		}
		case "registrar resultados": {
			mainFrame.setContentSubmenu(mainFrame.getRegistroPanel());
			break;
		}
		case "salir": {
			WindowActionUtils.onExitEvent(mainFrame);
			break;
		}
		}
	}
	
	private void switchRegistroAction(String action) {
		RegistroPanel regPanel = mainFrame.getRegistroPanel();
		switch (action) {
		case "guardar datos": {
			Object[] result = regPanel.validateData();
			WindowActionUtils.promptInfoDialog(mainFrame,
					(String) result[0], 
					(int) result[1]);
			if ((boolean) result[2]) {
				HashMap<String, JSpinner> spnPaisPuntMap = regPanel.getSpnPaisPuntMap();
				for (String pais : spnPaisPuntMap.keySet()) {					
					if (persistence.updateResultado((con, pstmt) -> {
							String query = SQLQueryBuilder.buildUpdateQuery(
									TableContract.PARTICIPANTES.toString(), 
									new String[] { 
											ResultadoContract.PUNTOS_PUBLICO.toString(),
											ResultadoContract.PUNTOS.toString()
									},
									ResultadoContract.PAIS.toString());
							pstmt = con.prepareStatement(query);
							pstmt.setInt(1, (int) spnPaisPuntMap.get(pais).getValue());
							pstmt.setInt(2, (int) spnPaisPuntMap.get(pais).getValue()
									+ persistence.getPuntosJurado(pais));
							pstmt.setString(3, pais);
							return pstmt;
					}) != 1) {
						System.err.println(String.format("Error al introducir el pais %s", pais));
					}
				}
			}
			break;
		}
		case "limpiar datos": {
			regPanel.limpiarCampos();
			break;
		}
		}
	}

}
