package org.uem.gestor_resultados_eurovision.view.submenus;

import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import net.miginfocom.swing.MigLayout;
import javax.swing.border.TitledBorder;

import org.uem.gestor_resultados_eurovision.control.MainController;
import org.uem.gestor_resultados_eurovision.utils.WindowActionUtils;
import org.uem.gestor_resultados_eurovision.view.ComponentView;

public class RegistroPanel extends JPanel implements ComponentView {
	
	private HashMap<String, JSpinner> spnPaisPuntMap = new HashMap<String, JSpinner>();
	private JButton btnGuardar;
	private JButton btnLimpiar;
	
	public RegistroPanel() {
		setBorder(new TitledBorder(null, "Registrar puntos p\u00FAblico", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		initComponents();
		initAttributes();
	}

	@Override
	public void initComponents() {
		setLayout(new MigLayout("", "[grow][50px:n,fill][][grow][50px:n,fill][]", "[][][][][][][][][][][][][][grow,bottom]"));
		
		JLabel lblPais = new JLabel("Alemania");
		add(lblPais, "cell 0 0,alignx center");
		
		spnPaisPuntMap.put("Alemania", new JSpinner());		
		add(spnPaisPuntMap.get("Alemania"), "cell 1 0,alignx center");
		
		JLabel lblMoldavia = new JLabel("Moldavia");
		add(lblMoldavia, "cell 3 0,alignx center");
		
		spnPaisPuntMap.put("Moldavia", new JSpinner());
		add(spnPaisPuntMap.get("Moldavia"), "cell 4 0,alignx center");
		
		JLabel lblArmenia = new JLabel("Armenia");
		add(lblArmenia, "cell 0 1,alignx center");
		
		spnPaisPuntMap.put("Armenia", new JSpinner());
		add(spnPaisPuntMap.get("Armenia"), "cell 1 1,alignx center");
		
		JLabel lblNoruega = new JLabel("Noruega");
		add(lblNoruega, "cell 3 1,alignx center");
		
		spnPaisPuntMap.put("Noruega", new JSpinner());
		add(spnPaisPuntMap.get("Noruega"), "cell 4 1,alignx center");
		
		JLabel lblAustralia = new JLabel("Australia");
		add(lblAustralia, "cell 0 2,alignx center");
		
		spnPaisPuntMap.put("Australia", new JSpinner());
		add(spnPaisPuntMap.get("Australia"), "cell 1 2,alignx center");
		
		JLabel lblPasesBajos = new JLabel("Países Bajos");
		add(lblPasesBajos, "cell 3 2,alignx center");
		
		spnPaisPuntMap.put("Países Bajos", new JSpinner());
		add(spnPaisPuntMap.get("Países Bajos"), "cell 4 2,alignx center");
		
		JLabel lblAzerbaiyan = new JLabel("Azerbaiyán");
		add(lblAzerbaiyan, "cell 0 3,alignx center,aligny baseline");
		
		spnPaisPuntMap.put("Azerbaiyán", new JSpinner());
		add(spnPaisPuntMap.get("Azerbaiyán"), "cell 1 3,alignx center");
		
		JLabel lblPolonia = new JLabel("Polonia");
		add(lblPolonia, "cell 3 3,alignx center");
		
		spnPaisPuntMap.put("Polonia", new JSpinner());
		add(spnPaisPuntMap.get("Polonia"), "cell 4 3,alignx center");
		
		JLabel lblBlgica = new JLabel("Bélgica");
		add(lblBlgica, "cell 0 4,alignx center");
		
		spnPaisPuntMap.put("Bélgica", new JSpinner());
		add(spnPaisPuntMap.get("Bélgica"), "cell 1 4,alignx center");
		
		JLabel lblPortugal = new JLabel("Portugal");
		add(lblPortugal, "cell 3 4,alignx center");
		
		spnPaisPuntMap.put("Portugal", new JSpinner());
		add(spnPaisPuntMap.get("Portugal"), "cell 4 4,alignx center");
		
		JLabel lblEspaa = new JLabel("España");
		add(lblEspaa, "cell 0 5,alignx center");
		
		spnPaisPuntMap.put("España", new JSpinner());
		add(spnPaisPuntMap.get("España"), "cell 1 5,alignx center");
		
		JLabel lblReinoUnido = new JLabel("Reino Unido");
		add(lblReinoUnido, "cell 3 5,alignx center");
		
		spnPaisPuntMap.put("Reino Unido", new JSpinner());
		add(spnPaisPuntMap.get("Reino Unido"), "cell 4 5,alignx center");
		
		JLabel lblEstonia = new JLabel("Estonia");
		add(lblEstonia, "cell 0 6,alignx center");
		
		spnPaisPuntMap.put("Estonia", new JSpinner());
		add(spnPaisPuntMap.get("Estonia"), "cell 1 6,alignx center");
		
		JLabel lblRepblicaCheca = new JLabel("República Checa");
		add(lblRepblicaCheca, "cell 3 6,alignx center");
		
		spnPaisPuntMap.put("República Checa", new JSpinner());
		add(spnPaisPuntMap.get("República Checa"), "cell 4 6,alignx center");
		
		JLabel lblFinlandia = new JLabel("Finlandia");
		add(lblFinlandia, "cell 0 7,alignx center");
		
		spnPaisPuntMap.put("Finlandia", new JSpinner());
		add(spnPaisPuntMap.get("Finlandia"), "cell 1 7,alignx center");
		
		JLabel lblRumana = new JLabel("Rumanía");
		add(lblRumana, "cell 3 7,alignx center");
		
		spnPaisPuntMap.put("Rumanía", new JSpinner());
		add(spnPaisPuntMap.get("Rumanía"), "cell 4 7,alignx center");
		
		JLabel lblFrancia = new JLabel("Francia");
		add(lblFrancia, "cell 0 8,alignx center");
		
		spnPaisPuntMap.put("Francia", new JSpinner());
		add(spnPaisPuntMap.get("Francia"), "cell 1 8,alignx center");
		
		JLabel lblSerbia = new JLabel("Serbia");
		add(lblSerbia, "cell 3 8,alignx center");
		
		spnPaisPuntMap.put("Serbia", new JSpinner());
		add(spnPaisPuntMap.get("Serbia"), "cell 4 8,alignx center");
		
		JLabel lblGrecia = new JLabel("Grecia");
		add(lblGrecia, "cell 0 9,alignx center");
		
		spnPaisPuntMap.put("Grecia", new JSpinner());
		add(spnPaisPuntMap.get("Grecia"), "cell 1 9,alignx center");
		
		JLabel lblSuecia = new JLabel("Suecia");
		add(lblSuecia, "cell 3 9,alignx center");
		
		spnPaisPuntMap.put("Suecia", new JSpinner());
		add(spnPaisPuntMap.get("Suecia"), "cell 4 9,alignx center");
		
		JLabel lblIslandia = new JLabel("Islandia");
		add(lblIslandia, "cell 0 10,alignx center");
		
		spnPaisPuntMap.put("Islandia", new JSpinner());
		add(spnPaisPuntMap.get("Islandia"), "cell 1 10,alignx center");
		
		JLabel lblSuiza = new JLabel("Suiza");
		add(lblSuiza, "cell 3 10,alignx center");
		
		spnPaisPuntMap.put("Suiza", new JSpinner());
		add(spnPaisPuntMap.get("Suiza"), "cell 4 10,alignx center");
		
		JLabel lblItalia = new JLabel("Italia");
		add(lblItalia, "cell 0 11,alignx center");
		
		spnPaisPuntMap.put("Italia", new JSpinner());
		add(spnPaisPuntMap.get("Italia"), "cell 1 11,alignx center");
		
		JLabel lblUcrania = new JLabel("Ucrania");
		add(lblUcrania, "cell 3 11,alignx center");
		
		spnPaisPuntMap.put("Ucrania", new JSpinner());
		add(spnPaisPuntMap.get("Ucrania"), "cell 4 11,alignx center");
		
		JLabel lblNewLabel = new JLabel("Lituania");
		add(lblNewLabel, "cell 0 12,alignx center");
		
		spnPaisPuntMap.put("Lituania", new JSpinner());
		add(spnPaisPuntMap.get("Lituania"), "cell 1 12,alignx center");
		
		btnGuardar = new JButton("Guardar datos");
		add(btnGuardar, "cell 0 13 2 1,growx");
		
		btnLimpiar = new JButton("Limpiar datos");
		add(btnLimpiar, "cell 3 13 2 1,growx");
		
		btnGuardar.putClientProperty("CallerID", "registroPanel");
		btnLimpiar.putClientProperty("CallerID", "registroPanel");
	}

	@Override
	public void initAttributes() {
		for (JSpinner spn : spnPaisPuntMap.values()) {
			((SpinnerNumberModel) spn.getModel()).setMaximum(100);
			((SpinnerNumberModel) spn.getModel()).setMinimum(0);
		}
	}

	@Override
	public void updateListeners(MainController listener) {
		btnGuardar.addActionListener(listener);
		btnLimpiar.addActionListener(listener);
	}

	public HashMap<String, JSpinner> getSpnPaisPuntMap() {
		return spnPaisPuntMap;
	}

	public Object[] validateData() {
		int total = 0;
		for (JSpinner spn : spnPaisPuntMap.values()) {
			total += (int) spn.getValue();
		}
		if (total > 100) {
			return new Object[] {
					String.format("El total de puntos introducidos (%s) no puede superar al 100", total) + "%",
					JOptionPane.ERROR_MESSAGE,
					false
			};
		} else if (total < 100) {
			return new Object[] {
					String.format("La suma total (%s) no puede ser inferior al 100", total) + "%",
					JOptionPane.ERROR_MESSAGE,
					false
			};
		}
		return new Object[] {
				"Se ha registrado el resultado con éxito",
				JOptionPane.INFORMATION_MESSAGE,
				true
		};
	}
	
	public void limpiarCampos() {
		for (JSpinner spn : spnPaisPuntMap.values()) {
			spn.setValue(0);;
		}
	}

}
