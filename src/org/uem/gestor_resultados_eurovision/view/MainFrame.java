package org.uem.gestor_resultados_eurovision.view;

import javax.swing.JFrame;

import net.miginfocom.swing.MigLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import org.uem.gestor_resultados_eurovision.control.MainController;
import org.uem.gestor_resultados_eurovision.view.submenus.ConsultaPanel;
import org.uem.gestor_resultados_eurovision.view.submenus.RegistroPanel;

public class MainFrame extends JFrame implements ComponentView {
	private ConsultaPanel consultaPanel;
	private RegistroPanel registroPanel;
	private JMenuItem mntmConsulta;
	private JMenuItem mntmRegistro;
	private JMenuItem mntmSalir;
	
	public MainFrame() {
		initComponents();
		initAttributes();		
	}

	@Override
	public void initComponents() {
		setTitle("Gestion Datos Eurovision");
		getContentPane().setLayout(new MigLayout("", "[grow][]", "[grow]"));
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mntmConsulta = new JMenuItem("Consulta de Resultados");
		menuBar.add(mntmConsulta);
		
		mntmRegistro = new JMenuItem("Registrar Resultados");
		menuBar.add(mntmRegistro);
		
		mntmSalir = new JMenuItem("Salir");
		menuBar.add(mntmSalir);
		
		mntmConsulta.putClientProperty("CallerID", "mainView");
		mntmRegistro.putClientProperty("CallerID", "mainView");
		mntmSalir.putClientProperty("CallerID", "mainView");
		
		consultaPanel = new ConsultaPanel();
		getContentPane().add(consultaPanel, "grow");
		registroPanel = new RegistroPanel();
		getContentPane().add(registroPanel, "grow");
	}

	@Override
	public void initAttributes() {
		pack();
		setVisible(true);
		setContentSubmenu(null);
		setMinimumSize(this.getSize());
		// quiero manipular las acciones de la ventana cuando se vaya a cerrar (exponer dialogo de cierre)
		// al presionar el boton de cierre de la ventana
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
	}

	@Override
	public void updateListeners(MainController listener) {
		mntmConsulta.addActionListener(listener);
		mntmRegistro.addActionListener(listener);
		mntmSalir.addActionListener(listener);
		// propagar la llamada a todos los contenedores hijos
		consultaPanel.updateListeners(listener);
		registroPanel.updateListeners(listener);
		this.addWindowListener(listener.getWinAdapter());
	}

	public ConsultaPanel getConsultaPanel() {
		return consultaPanel;
	}

	public RegistroPanel getRegistroPanel() {
		return registroPanel;
	}
	
	public void setContentSubmenu(JPanel submenu) {
		if (submenu != null) {
			submenu.setVisible(true);
			this.setContentPane(submenu);
			this.repaint();
			this.pack();
		} else {
			consultaPanel.setVisible(false);
			registroPanel.setVisible(false);			
		}
	}

}
