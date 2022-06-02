package org.uem.gestor_resultados_eurovision.view.submenus;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.uem.gestor_resultados_eurovision.contract.ResultadoContract;
import org.uem.gestor_resultados_eurovision.control.MainController;
import org.uem.gestor_resultados_eurovision.model.Resultado;
import org.uem.gestor_resultados_eurovision.view.ComponentView;

public class ConsultaPanel extends JPanel implements ComponentView {
	private JTable table;
	public ConsultaPanel() {
		initComponents();
		initAttributes();
	}

	@Override
	public void initComponents() {
		setBorder(new TitledBorder(null, "Consulta de Resultados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 0 0,grow");
		
		table = new JTable();
		table.setRowSelectionAllowed(false);
		table.setEnabled(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"POSICION"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
	}
	
	@Override
	public void initAttributes() {
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		for (String col: ResultadoContract.getTableCols()) {
			tableModel.addColumn(col);
		}
	}
	
	@Override
	public void updateListeners(MainController listener) {
	}
	
	public void updateTable(ArrayList<Resultado> resultados) {
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);
		for (Resultado resultado: resultados) {
			tableModel.addRow(resultado.toStringArray().toArray());
		}
	}
	
}
