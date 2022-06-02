package org.uem.gestor_resultados_eurovision.view;

import org.uem.gestor_resultados_eurovision.control.MainController;

public interface ComponentView {
	void initComponents();
	void initAttributes();
	void updateListeners(MainController listener);
}
