package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

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
import javax.swing.table.TableColumnModel;
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
	private static JFormattedTextField txtBuscar;
	private JFormattedTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JFormattedTextField txtTelefono;
	public Cliente cliente;
	public Factura aux2=null;
	public String aux;
	public JButton btnModificar;


	/**
	 * Create the dialog.
	 * @param mialma 
	 */
	public ListaFactura(String aux) {
		this.cliente = Altice.getInstance().buscarCliente(aux);
		this.aux=aux;
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
				scrollPane.setBounds(10, 135, 827, 174);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panel.add(scrollPane);
				{	
					modelo = new DefaultTableModel();
					String[] headers = {"Codigo", "Empleado", "Fecha","Monto"};
					modelo.setColumnIdentifiers(headers);
					
					table = new JTable();
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							int seleccionarFactura= table.getSelectedRow();
							if(seleccionarFactura!=-1) {
								identificacion = (String)table.getModel().getValueAt(seleccionarFactura, 2);
								cedula = (String)table.getModel().getValueAt(seleccionarFactura, 0);
								btnModificar.setEnabled(true);
								aux2 = Altice.getInstance().buscarCodigo((String)modelo.getValueAt(seleccionarFactura, 0));
						}
					 }
					});
									
					table.setModel(modelo);
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					//cargarTabla(null);
					scrollPane.setViewportView(table);
				}
			}
			
			txtBuscar = new JFormattedTextField();
			try {
				MaskFormatter formatoCedula= new MaskFormatter("###-#######-#");
				formatoCedula.setPlaceholderCharacter('_');
			}catch (Exception e) {
				// TODO: handle exception
			}
			
			try {
				MaskFormatter formatoTelefono= new MaskFormatter("(###)-###-####");
				formatoTelefono.setPlaceholderCharacter('_');
				txtTelefono = new JFormattedTextField(formatoTelefono);			
			}catch (Exception e) {
				// TODO: handle exception
			}
			

			
			JPanel panel_2 = new JPanel();
			panel_2.setLayout(null);
			panel_2.setBorder(new TitledBorder(null, "Datos Del Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_2.setBounds(122, 28, 558, 106);
			panel.add(panel_2);
			
			JLabel label = new JLabel("Cedula:");
			label.setBounds(10, 27, 54, 14);
			panel_2.add(label);
			
			JLabel label_1 = new JLabel("Nombre:");
			label_1.setBounds(10, 59, 54, 14);
			panel_2.add(label_1);
			
			txtCedula = new JFormattedTextField();
			try {
				MaskFormatter formatoCedula= new MaskFormatter("###-#######-#");
				formatoCedula.setPlaceholderCharacter('_');
				txtCedula = new JFormattedTextField(formatoCedula);			
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
			
			txtTelefono = new JFormattedTextField();
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
				
				btnModificar = new JButton("Pagar");
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						PagarFact newp = new PagarFact(0,aux2.getMicliente());
						newp.setVisible(true);
						}
				});
				buttonPane.add(btnModificar);
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
			
			cargarTabla();	
			txtCedula.setText(cliente.getCedula());
			txtNombre.setText(cliente.getNombre());
			txtDireccion.setText(cliente.getDireccion());
			txtTelefono.setText(cliente.getTelefono());
	

	}
	



	public void cargarTabla() {
		modelo.setRowCount(0);
		fila = new Object[modelo.getColumnCount()];
		
		for (Factura factura : Altice.getInstance().getMisFacturas()) {
			if(cliente.getCedula().equalsIgnoreCase(factura.getMicliente().getCedula())){
			fila[0]=factura.getCodFact();
			fila[1]=factura.getMicliente().getNombre();
			fila[2]= "Empleado 1";
			//	fila[2]=factura.getEmpleado().getNombre();
			fila[3]=factura.getFecha();

			
			modelo.addRow(fila);
			}
		}
	}
	
	
}