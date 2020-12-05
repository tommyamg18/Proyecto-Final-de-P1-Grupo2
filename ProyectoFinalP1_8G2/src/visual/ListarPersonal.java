package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logic.Administrativo;
import logic.Altice;
import logic.Comercial;
import logic.Personal;
import logic.Plan;


import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Rectangle;

public class ListarPersonal extends JDialog {

	private final JPanel contentPanel = new JPanel();
	 public static DefaultTableModel modelo;
	 public static Object[] filas;
	 private String ced;
	 private JTable table;
	 private JButton btnEliminar;
	 private JPanel panel;
	 private JPanel panel_1;
	 private JLabel lblNewLabel;
	 private JComboBox cmbTipo;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListarPersonal dialog = new ListarPersonal();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListarPersonal() {
		setTitle("Listado de Personal");
		setBounds(100, 100, 782, 453);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			panel = new JPanel();
			panel.setBounds(0, 0, 766, 381);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				panel_1 = new JPanel();
				panel_1.setBounds(10, 56, 746, 314);
				panel.add(panel_1);
				panel_1.setLayout(null);
				
				{
					
					
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setBounds(0, 0, 746, 314);
					scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
					panel_1.add(scrollPane);
					{
						modelo = new DefaultTableModel();
						String[] headers = {"Cédula","Tipo","Nombre","Teléfono","Dirección", "Sueldo"};
						modelo.setColumnIdentifiers(headers);
						table = new JTable();
						table.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								int seleccion = table.getSelectedRow();
								if(seleccion!=-1){
								  btnEliminar.setEnabled(true);
								  ced = (String)table.getModel().getValueAt(seleccion, 0);
								}
							}
						});
						table.setModel(modelo);
						table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						scrollPane.setViewportView(table);
					}
				}
			}
			{
				lblNewLabel = new JLabel("Tipo de personal:");
				lblNewLabel.setBounds(10, 21, 115, 14);
				panel.add(lblNewLabel);
			}
			{
				cmbTipo = new JComboBox();
				cmbTipo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int index = cmbTipo.getSelectedIndex();
						llenarTabla(index);

					}
				});
				cmbTipo.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Administrativo", "Comercial"}));
				cmbTipo.setBounds(117, 18, 128, 20);
				panel.add(cmbTipo);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						/*Personal aux = Altice.getInstance().con
						if(aux!=null) {
						int option = JOptionPane.showConfirmDialog(null, "Está seguro que desea eliminar el personal: "+aux.getCodPlan(), "Confirmación", JOptionPane.WARNING_MESSAGE);
						if(option == JOptionPane.OK_OPTION) {
							Altice.getInstance().eliminarPlan(aux);
							llenarTabla(0);
							btnEliminar.setEnabled(false);
						}
					}*/
						
					}
				});
				btnEliminar.setActionCommand("OK");
				buttonPane.add(btnEliminar);
				getRootPane().setDefaultButton(btnEliminar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		llenarTabla(0);
	}
	public static void llenarTabla(int x) {
		modelo.setRowCount(0);
		filas = new Object[modelo.getColumnCount()];		
		for (Personal personal : Altice.getInstance().getMiPersonal()) {
			if(personal instanceof Personal){
				if(x==0){	
				filas[0] = personal.getCedula();
				if(personal instanceof Administrativo)
				{
					filas[1] = "Administrativo";
				}
				if(personal instanceof Comercial)
				{

					filas[1] =  "Comercial";
				}
				filas[2] = personal.getNombre();
			    filas[3] = personal.getTelefono();
			    filas[4] = personal.getDireccion();
			    filas[5] = personal.getSalarioMes();
			  
			       modelo.addRow(filas);
				}
				if(x==2){
					if(personal instanceof Comercial){
						filas[0] = personal.getCedula();
						filas[1] =  "Comercial";
						filas[2] = personal.getNombre();
					    filas[3] = personal.getTelefono();
					    filas[4] = personal.getDireccion();
					    filas[5] = personal.getSalarioMes();
				    modelo.addRow(filas);
				}
				}
				
				if(x==1){
					if(personal instanceof Administrativo){
						filas[0] = personal.getCedula();
						filas[1] =  "Administrativo";
						filas[2] = personal.getNombre();
					    filas[3] = personal.getTelefono();
					    filas[4] = personal.getDireccion();
					    filas[5] = personal.getSalarioMes();
				    modelo.addRow(filas);
					}
				}
				
				
				
				
			}
		}

	}

}
