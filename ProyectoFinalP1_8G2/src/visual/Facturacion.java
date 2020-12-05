package visual;

import java.awt.BorderLayout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
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

	/**
	 * 
	 */
	private static final long serialVersionUID = 3318872162197742334L;
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
 	ArrayList<Plan> plan = new ArrayList<>();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Facturacion dialog = new Facturacion(0,null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Facturacion(int mod, Cliente miCliente) {
		setTitle("Facturaci\u00F3n");
		setBounds(100, 100, 1086, 463);
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
				scrollPane.setBounds(26, 57, 485, 236);
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
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setLayout(null);
				panel_1.setBorder(new TitledBorder(null, "Datos Del Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_1.setBounds(537, 57, 485, 236);
				panel.add(panel_1);
				{
					JLabel label = new JLabel("Cedula:");
					label.setBounds(10, 41, 98, 27);
					panel_1.add(label);
				}
				{
					JLabel label = new JLabel("Nombre:");
					label.setBounds(10, 96, 128, 27);
					panel_1.add(label);
				}
				{
					txtCedula = new JTextField();
					try {
						MaskFormatter formatoCedula= new MaskFormatter("###-#######-#");
						formatoCedula.setPlaceholderCharacter('_');
						txtCedula = new JFormattedTextField(formatoCedula);			
					}catch (Exception e) {
						// TODO: handle exception
					}
					txtCedula.setEditable(false);
					txtCedula.setColumns(10);
					txtCedula.setBounds(164, 50, 174, 23);
					panel_1.add(txtCedula);
				}
				{
					txtNombre = new JTextField();
					txtNombre.setEditable(false);
					txtNombre.setColumns(10);
					txtNombre.setBounds(164, 101, 174, 23);
					panel_1.add(txtNombre);
				}
				{
					JLabel label = new JLabel("Direccion:");
					label.setBounds(10, 151, 128, 27);
					panel_1.add(label);
				}
				{
					JLabel label = new JLabel("Telefono:");
					label.setBounds(10, 206, 128, 27);
					panel_1.add(label);
				}
				{
					txtDireccion = new JTextField();
					txtDireccion.setEditable(false);
					txtDireccion.setColumns(10);
					txtDireccion.setBounds(164, 157, 229, 23);
					panel_1.add(txtDireccion);
				}
				{
					txtTelefono = new JTextField();
					txtTelefono.setEditable(false);
					txtTelefono.setColumns(10);
					txtTelefono.setBounds(164, 207, 119, 23);
					panel_1.add(txtTelefono);
				}
			}
			{
				JLabel lblNewLabel = new JLabel("Planes:");
				lblNewLabel.setBounds(210, 14, 86, 42);
				panel.add(lblNewLabel);
			}
			
			
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Pago");
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
		if(miCliente!=null) {
			cargarCliente(miCliente);
		}
	}

	protected void cargarCliente(Cliente client) {
		// TODO Auto-generated method stub
		
		txtCedula.setText(client.getCedula());
		txtNombre.setText(client.getNombre());
		txtDireccion.setText(client.getDireccion());
		txtTelefono.setText(client.getTelefono());
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