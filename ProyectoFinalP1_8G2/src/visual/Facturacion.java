package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import logic.Altice;
import logic.Cliente;
import logic.Factura;
import logic.Plan;


import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;

public class Facturacion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public static JTable table;
	private static Object[] fila;
	private static DefaultTableModel modelo;
	private String cedula;
	private String identificacion;
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JFormattedTextField txtBuscar;
 	ArrayList<Plan> plan = new ArrayList<>();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Facturacion dialog = new Facturacion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Facturacion() {
		setTitle("Facturaci\u00F3n");
		setBounds(100, 100, 715, 344);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Factura", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 125, 356, 131);
				panel.add(scrollPane);
				{
					modelo = new DefaultTableModel();
					String[] columns = {"Plan", ""}; 
					modelo.setColumnIdentifiers(columns);
					
					table = new JTable();
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							int seleccionarPlan= table.getSelectedRow();
							if(seleccionarPlan!=-1) {
								identificacion = (String)table.getModel().getValueAt(seleccionarPlan, 2);
								cedula = (String)table.getModel().getValueAt(seleccionarPlan, 0);
						}
					 }
					});
									
					table.setModel(modelo);
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					cargarTabla(null);
					scrollPane.setViewportView(table);
				}
				JPanel panel_1 = new JPanel();
				panel_1.setLayout(null);
				panel_1.setBorder(new TitledBorder(null, "Buscar Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_1.setBounds(10, 26, 356, 75);
				panel.add(panel_1);
				{
					JLabel label = new JLabel("C\u00E9dula:");
					label.setBounds(10, 42, 65, 14);
					panel_1.add(label);
				}
				{
					txtBuscar = new JFormattedTextField((AbstractFormatter) null);
					try {
						MaskFormatter formatoCedula= new MaskFormatter("###-#######-#");
						formatoCedula.setPlaceholderCharacter('_');
						txtBuscar = new JFormattedTextField(formatoCedula);			
					}catch (Exception e) {
						// TODO: handle exception
					}
					txtBuscar.setColumns(10);
					txtBuscar.setBounds(66, 38, 163, 23);
					panel_1.add(txtBuscar);
				}
				{
					JButton button = new JButton("Buscar");
					button.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							if(!txtBuscar.getText().equalsIgnoreCase("___-_______-_") ){
								Cliente client = Altice.getInstance().buscarCliente(txtBuscar.getText());

							if(client != null){
								cargarTabla((Cliente)Altice.getInstance().buscarCliente(txtBuscar.getText()));	
								txtCedula.setText(String.valueOf(client.getCedula()));
								txtNombre.setText(String.valueOf(client.getNombre()));
								txtDireccion.setText(String.valueOf(client.getDireccion()));
								txtTelefono.setText(String.valueOf(client.getTelefono()));
								clear();
							}else{
								JOptionPane.showMessageDialog(null, "El cliente no fue encontrado", null, JOptionPane.WARNING_MESSAGE, null);
								txtBuscar.setText(null);
							}
						}
							else {
								JOptionPane.showMessageDialog(null, "Introduzca una cédula válida para continuar", null, JOptionPane.ERROR_MESSAGE, null);
							}
						}

						private void clear() {
							// TODO Auto-generated method stub
							txtBuscar.setText("");
						}
					});
					button.setBounds(236, 38, 89, 23);
					panel_1.add(button);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setLayout(null);
				panel_1.setBorder(new TitledBorder(null, "Datos Del Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_1.setBounds(369, 26, 316, 230);
				panel.add(panel_1);
				{
					JLabel label = new JLabel("Cedula:");
					label.setBounds(10, 41, 54, 14);
					panel_1.add(label);
				}
				{
					JLabel label = new JLabel("Nombre:");
					label.setBounds(10, 96, 54, 14);
					panel_1.add(label);
				}
				{
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
					txtCedula.setBounds(64, 41, 174, 23);
					panel_1.add(txtCedula);
				}
				{
					txtNombre = new JTextField();
					txtNombre.setEditable(false);
					txtNombre.setColumns(10);
					txtNombre.setBounds(64, 91, 174, 23);
					panel_1.add(txtNombre);
				}
				{
					JLabel label = new JLabel("Direccion:");
					label.setBounds(10, 151, 67, 14);
					panel_1.add(label);
				}
				{
					JLabel label = new JLabel("Telefono:");
					label.setBounds(10, 206, 67, 14);
					panel_1.add(label);
				}
				{
					txtDireccion = new JTextField();
					txtDireccion.setEditable(false);
					txtDireccion.setColumns(10);
					txtDireccion.setBounds(64, 147, 229, 23);
					panel_1.add(txtDireccion);
				}
				{
					txtTelefono = new JTextField();
					txtTelefono.setEditable(false);
					txtTelefono.setColumns(10);
					txtTelefono.setBounds(64, 197, 119, 23);
					panel_1.add(txtTelefono);
				}
			}
			{
				JLabel lblNewLabel = new JLabel("Planes:");
				lblNewLabel.setBounds(10, 112, 46, 14);
				panel.add(lblNewLabel);
			}
			
			
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Pago");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						//Factura fact = factura(client);
						if(!txtCedula.getText().equalsIgnoreCase("")&& plan.size()!=0){			
							//Date fecha = new Date();
							Cliente client = Altice.getInstance().buscarCliente(txtBuscar.getText());
							Factura fact1 = Altice.getInstance().buscarCodigo(identificacion);
							Factura fact = new Factura(client, fact1);
							fact.setMisPlanes(plan);;
							Altice.getInstance().crearFactura(fact);
														
							JOptionPane.showMessageDialog(null, "Pago realizada satisfectoriamente", null, JOptionPane.INFORMATION_MESSAGE, null);
							clear();
							} else {
								JOptionPane.showMessageDialog(null, "Favor Seleccionar Algun Plan o Introducir su Cédula", null, JOptionPane.ERROR_MESSAGE, null);
								
							}
						/*ListCliente lisClient = new ListCliente(cliente, fact);
						lisClient.setModal(true);
						lisClient.setLocationRelativeTo(null);
						lisClient.setVisible(true);*/
					}

					private void clear() {
						// TODO Auto-generated method stub
						txtBuscar.setText("");
						txtNombre.setText("");
						txtCedula.setText("");
						txtDireccion.setText("");
						txtTelefono.setText("");
						ArrayList<Plan> plan = new ArrayList<>();
					}

					/*private Factura factura(Cliente client) {
						// TODO Auto-generated method stub
						 ArrayList<Factura> fact= new ArrayList<>();	
						 for (Factura aux : ((Cliente)client).get) {
						  	  fact.add(aux);
					}
						return null;
					}*/
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	private void cargarTabla(Cliente cliente) {
		// TODO Auto-generated method stub
		
			for (Factura fact : Altice.getInstance().getMisFacturas()) {
				if(cliente.getCedula().equalsIgnoreCase(fact.getMicliente().getCedula())){

				//System.out.println("codigo de factura"+aux.getCodigoFactura()+aux.isEstado());
				//fila[0]= plan.;
				//fila[1] = plan.getFecha();
				
				modelo.addRow(fila);
			
		}
			}
	}
}
