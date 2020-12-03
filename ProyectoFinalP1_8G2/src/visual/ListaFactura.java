package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import logic.Altice;
import logic.Factura;
import logic.Cliente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class ListaFactura extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public static JTable table;
	private static Object[] fila;
	private static DefaultTableModel modelo;
	private String cedula;
	private String identificacion;
	private JButton btnNewButton;
	private JTextField txtBuscar;
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtTelefono;


	/**
	 * Create the dialog.
	 * @param mialma 
	 */
	public ListaFactura() {
		setTitle("Listado de Facturas");
		setResizable(false);
		setBounds(100, 100, 862, 445);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Facturas por Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 135, 827, 227);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panel.add(scrollPane);
				{
					modelo = new DefaultTableModel();
					String[] columns = {""}; 
					modelo.setColumnIdentifiers(columns);
					
					table = new JTable();
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							int seleccionarFactura= table.getSelectedRow();
							if(seleccionarFactura!=-1) {
								identificacion = (String)table.getModel().getValueAt(seleccionarFactura, 2);
								cedula = (String)table.getModel().getValueAt(seleccionarFactura, 0);
						}
					 }
					});
									
					table.setModel(modelo);
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					cargarTabla(null);
					scrollPane.setViewportView(table);
				}
			}
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "Buscar Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(10, 18, 265, 106);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("C\u00E9dula:");
			lblNewLabel.setBounds(10, 42, 65, 14);
			panel_1.add(lblNewLabel);
			
			txtBuscar = new JTextField();
			try {
				MaskFormatter formatoCedula= new MaskFormatter("###-#######-#");
				formatoCedula.setPlaceholderCharacter('_');
				txtBuscar = new JFormattedTextField(formatoCedula);			
			}catch (Exception e) {
				// TODO: handle exception
			}
			txtBuscar.setBounds(66, 38, 163, 23);
			panel_1.add(txtBuscar);
			txtBuscar.setColumns(10);
			
			btnNewButton = new JButton("Buscar");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					{
						Cliente client = Altice.getInstance().buscarCliente(txtBuscar.getText());
						if(!txtBuscar.getText().equalsIgnoreCase("___-_______-_")) {
						if(client != null){
							cargarTabla((Cliente)Altice.getInstance().buscarCliente(txtBuscar.getText()));	
							txtCedula.setText(String.valueOf(client.getCedula()));
							txtNombre.setText(String.valueOf(client.getNombre()));
							txtDireccion.setText(String.valueOf(client.getDireccion()));
							txtTelefono.setText(String.valueOf(client.getTelefono()));
							clear();
						}else{
							JOptionPane.showMessageDialog(null, "El cliente no fue encontrado", null, JOptionPane.WARNING_MESSAGE, null);
							clear();
						}
					} else {
						JOptionPane.showMessageDialog(null, "Favor revisar que todos los campos estén llenos", null, JOptionPane.ERROR_MESSAGE, null);
						clear();
					}
				}
			}

				private void clear() {
				// TODO Auto-generated method stub
				txtBuscar.setText("");
			}
			});
			btnNewButton.setBounds(140, 72, 89, 23);
			panel_1.add(btnNewButton);
			
			JPanel panel_2 = new JPanel();
			panel_2.setLayout(null);
			panel_2.setBorder(new TitledBorder(null, "Datos Del Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_2.setBounds(279, 18, 558, 106);
			panel.add(panel_2);
			
			JLabel label = new JLabel("Cedula:");
			label.setBounds(10, 27, 54, 14);
			panel_2.add(label);
			
			JLabel label_1 = new JLabel("Nombre:");
			label_1.setBounds(10, 59, 54, 14);
			panel_2.add(label_1);
			
			txtCedula = new JTextField();
			try {
				MaskFormatter formatoCedula= new MaskFormatter("###-#######-#");
				formatoCedula.setPlaceholderCharacter('_');
				txtBuscar = new JFormattedTextField(formatoCedula);			
			}catch (Exception e) {
				// TODO: handle exception
			}
			txtCedula.setEditable(false);
			txtCedula.setColumns(10);
			txtCedula.setBounds(66, 24, 174, 23);
			panel_2.add(txtCedula);
			
			txtNombre = new JTextField();
			txtNombre.setEditable(false);
			txtNombre.setColumns(10);
			txtNombre.setBounds(66, 56, 174, 23);
			panel_2.add(txtNombre);
			
			JLabel label_2 = new JLabel("Direccion:");
			label_2.setBounds(259, 27, 67, 14);
			panel_2.add(label_2);
			
			JLabel label_3 = new JLabel("Telefono:");
			label_3.setBounds(259, 59, 67, 14);
			panel_2.add(label_3);
			
			txtDireccion = new JTextField();
			txtDireccion.setEditable(false);
			txtDireccion.setColumns(10);
			txtDireccion.setBounds(319, 23, 229, 23);
			panel_2.add(txtDireccion);
			
			txtTelefono = new JTextField();
			txtTelefono.setEditable(false);
			txtTelefono.setColumns(10);
			txtTelefono.setBounds(319, 55, 119, 23);
			panel_2.add(txtTelefono);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
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
		
		cargarTabla(null);
	}



	public static void cargarTabla(Cliente cliente) {
		modelo.setRowCount(0);
		fila = new Object[modelo.getColumnCount()];
		for (Factura factura : Altice.getInstance().getMisFacturas()) {
			
			if(cliente.getCedula().equalsIgnoreCase(factura.getMicliente().getCedula())){
			fila[0]=factura.getCodFact();
			fila[1]=factura.getEmpleado().getNombre();
			//fila[2]=factura.getEmpleado().getTipo;
			/*fila[0]=factura.getMicliente().getCedula();
			fila[1]=factura.getMicliente().getNombre();
			fila[3]=factura.getMisPlanes().;
			for (Plan plan : Altice.getInstance().getMisPlanes()) {
				if() {
					fila[4] = "Esferico";
				}
				if() {
					fila[4] = "Cilindrico";

				}
				if() {
					fila[4] = "Cilindrico-Hueco";

				}
			}*/
			modelo.addRow(fila);
			}
		}
		
	}
}