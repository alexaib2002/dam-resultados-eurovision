package org.uem.gestor_resultados_eurovision.main;

import org.uem.gestor_resultados_eurovision.control.MainController;
import org.uem.gestor_resultados_eurovision.view.MainFrame;

public class GestorResultadosEurovision {

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(() -> {
			MainFrame mainFrame = new MainFrame();
			MainController mainController = new MainController(mainFrame);
			mainFrame.updateListeners(mainController);
		});
	}

}
