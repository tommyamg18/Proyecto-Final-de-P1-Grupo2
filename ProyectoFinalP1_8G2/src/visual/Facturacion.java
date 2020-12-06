package visual;

import java.awt.BorderLayout;


import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import javax.swing.text.StyledEditorKit.ForegroundAction;

import logic.Altice;
import logic.Cliente;
import logic.Comercial;
import logic.Factura;
import logic.Plan;


import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;

import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JComboBox;

public class Facturacion extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3318872162197742334L;
	private final JPanel contentPanel = new JPanel();
	private String cedula;
	private JList listPlanFacturar;
	private JList listPlanDisponible;
	private String identificacion;
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtCodFac;
	private JComboBox cbxDetalle;
	private int index=-1;
	private int indexBack =-1;
	private JButton btnAgregar;
	private JButton btnQuitar;
	private String seleccion = "<Todos>";
    private ArrayList<String> planDisponible;
    private ArrayList<String> planDisponibleId=new ArrayList<>();
    private ArrayList<String> planFacturar = new ArrayList<>();
	private ArrayList<String> planFacturarId = new ArrayList<>();
	private double total=0;
	public Plan aux=null;
	private String cod;
 	ArrayList<Plan> plan = new ArrayList<>();
 	private JTextField txtTotal;
 	private JTextField txtISC;
 	private JTextField txtITBIS;
 	private JTextField txtCDS;


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
		setBounds(100, 100, 1086, 688);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		setModal(true);
		setResizable(false);
		
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Factura", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JPanel panel_1 = new JPanel();
				panel_1.setLayout(null);
				panel_1.setBorder(new TitledBorder(null, "Datos Del Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_1.setBounds(36, 28, 674, 134);
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
					txtCedula.setBounds(117, 49, 174, 23);
					panel_1.add(txtCedula);
				}
				{
					txtNombre = new JTextField();
					txtNombre.setEditable(false);
					txtNombre.setColumns(10);
					txtNombre.setBounds(117, 100, 174, 23);
					panel_1.add(txtNombre);
				}
				{
					JLabel label = new JLabel("Direccion:");
					label.setBounds(298, 41, 128, 27);
					panel_1.add(label);
				}
				{
					JLabel label = new JLabel("Telefono:");
					label.setBounds(298, 96, 128, 27);
					panel_1.add(label);
				}
				{
					txtDireccion = new JTextField();
					txtDireccion.setEditable(false);
					txtDireccion.setColumns(10);
					txtDireccion.setBounds(429, 49, 229, 23);
					panel_1.add(txtDireccion);
				}
				{
					txtTelefono = new JTextField();
					txtTelefono.setEditable(false);
					txtTelefono.setColumns(10);
					txtTelefono.setBounds(429, 98, 119, 23);
					panel_1.add(txtTelefono);
				}
			}
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Planes Disponibles:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_1.setBounds(26, 208, 429, 288);
			panel.add(panel_1);
			panel_1.setLayout(new BorderLayout(0, 0));
			
			listPlanDisponible = new JList();
			listPlanDisponible.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					index = listPlanDisponible.getSelectedIndex();
					if(index!=-1){
						btnAgregar.setEnabled(true);
					}
				}
			});
			panel_1.add(listPlanDisponible, BorderLayout.CENTER);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Planes a Facturar:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_2.setBounds(580, 208, 429, 288);
			panel.add(panel_2);
			panel_2.setLayout(new BorderLayout(0, 0));
			
			listPlanFacturar = new JList();
			panel_2.add(listPlanFacturar, BorderLayout.CENTER);
			listPlanFacturar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					indexBack = listPlanFacturar.getSelectedIndex();
					if(indexBack!=-1){
						btnQuitar.setEnabled(true);
					}
				}
			});
			
			btnAgregar = new JButton(">>");
			btnAgregar.setEnabled(false);
			btnAgregar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(index!=-1){
						planFacturar.add(planDisponible.get(index));
						planFacturarId.add(planDisponibleId.get(index));
						planDisponible.remove(index);
						planDisponibleId.remove(index);
						listPlanDisponible.removeAll();
						listPlanDisponible.setListData(planDisponible.toArray());
						listPlanFacturar.removeAll();
						listPlanFacturar.setListData(planFacturar.toArray());
						btnAgregar.setEnabled(false);
						actualizarMonto();
						cargarSeleccion();
						}
				}
			});
			btnAgregar.setBounds(473, 241, 92, 41);
			panel.add(btnAgregar);
			
			btnQuitar = new JButton("<<");
			btnQuitar.setEnabled(false);
			btnQuitar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(indexBack!=-1){
						  planDisponible.add(planFacturar.get(indexBack));
						  planDisponibleId.add(planFacturarId.get(indexBack));
						  planFacturar.remove(indexBack);
						  planFacturarId.remove(indexBack);
						  listPlanDisponible.removeAll();
						  listPlanDisponible.setListData(planDisponible.toArray());
						  listPlanFacturar.removeAll();
						  listPlanFacturar.setListData(planFacturar.toArray());
						  btnQuitar.setEnabled(false);
						  actualizarMonto();
						  cargarSeleccion();
						}
				}
			});
			btnQuitar.setBounds(473, 425, 92, 41);
			panel.add(btnQuitar);
			
			txtTotal = new JTextField();
			txtTotal.setEditable(false);
			txtTotal.setColumns(10);
			txtTotal.setBounds(802, 167, 236, 39);
			panel.add(txtTotal);
			
			JLabel label = new JLabel("Total:");
			label.setBounds(721, 170, 85, 33);
			panel.add(label);
			{
				JLabel lblIsc = new JLabel("ISC:");
				lblIsc.setBounds(721, 78, 85, 33);
				panel.add(lblIsc);
			}
			{
				txtISC = new JTextField();
				txtISC.setEditable(false);
				txtISC.setColumns(10);
				txtISC.setBounds(802, 75, 236, 39);
				panel.add(txtISC);
			}
			{
				JLabel lblItbis = new JLabel("ITBIS:");
				lblItbis.setBounds(721, 31, 85, 33);
				panel.add(lblItbis);
			}
			{
				txtITBIS = new JTextField();
				txtITBIS.setEditable(false);
				txtITBIS.setColumns(10);
				txtITBIS.setBounds(802, 28, 236, 39);
				panel.add(txtITBIS);
			}
			{
				JLabel lblCds = new JLabel("CDS:");
				lblCds.setBounds(721, 126, 85, 33);
				panel.add(lblCds);
			}
			{
				txtCDS = new JTextField();
				txtCDS.setEditable(false);
				txtCDS.setColumns(10);
				txtCDS.setBounds(802, 123, 236, 39);
				panel.add(txtCDS);
			}
			{
				JLabel lblCodigo = new JLabel("Codigo:");
				lblCodigo.setBounds(36, 170, 101, 33);
				panel.add(lblCodigo);
			}
			{
				txtCodFac = new JTextField();
				txtCodFac.setEditable(false);
				txtCodFac.setColumns(10);
				txtCodFac.setBounds(139, 167, 236, 39);
				panel.add(txtCodFac);
			}
			{
				JButton btnNewButton = new JButton("Detalle");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Plan miPlan=Altice.getInstance().consultarPlan(cbxDetalle.getSelectedItem().toString());
						CrearPlan newPlan = new CrearPlan(1,miPlan, null);
						newPlan.setVisible(true);
					}
				});
				btnNewButton.setBounds(590, 497, 171, 41);
				panel.add(btnNewButton);
			}
			
			cbxDetalle = new JComboBox();
			cbxDetalle.setBounds(787, 498, 171, 41);
			panel.add(cbxDetalle);
			
			
		}
		clean();
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Facturar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Factura aux = null;
						String codFactura = txtCodFac.getText();
						aux = new Factura (codFactura, miCliente, null, cargarPlanes(),Double.valueOf(txtTotal.getText()));
						Altice.getInstance().crearFactura(aux);
					    JOptionPane.showMessageDialog(null, "Registro satisfactorio", "Información", JOptionPane.INFORMATION_MESSAGE);
						clean();
						dispose();
					}
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
		if(miCliente!=null) {
			cargarCliente(miCliente);
		}
		cargarListaDisponible(seleccion);
		
	}

	private void cargarSeleccion() {
		cbxDetalle.removeAllItems();
		for (String Seleccion : planFacturarId) {
			cbxDetalle.addItem(Seleccion);
		}
	}

	protected void cargarCliente(Cliente client) {	
		txtCedula.setText(client.getCedula());
		txtNombre.setText(client.getNombre());
		txtDireccion.setText(client.getDireccion());
		txtTelefono.setText(client.getTelefono());
	}

	private void cargarListaDisponible( String seleccion) {
		planDisponible = new ArrayList<>();
		if(seleccion.equalsIgnoreCase("<Todos>")){ 
		 for (int i = 0; i < Altice.getInstance().getMisPlanes().size(); i++) {

		   planDisponible.add(new String(Altice.getInstance().getMisPlanes().get(i).getCodPlan() +" : "+Altice.getInstance().getMisPlanes().get(i).getNombre()+" : "+Math.round(Altice.getInstance().getMisPlanes().get(i).getPrecio()*100.0)/100.0));
		   planDisponibleId.add(new String(Altice.getInstance().getMisPlanes().get(i).getCodPlan()));
		  }
		}else{
		/*	 for (int i = 0; i < Altice.getInstance().getMisPlanes().size(); i++) {
			  if(seleccion.equalsIgnoreCase("<Queso Cilindrico>")) {
					 nombre = "Queso Cilíndrico ";
					 planDisponible.add(new String(Fabrica.getInstance().getMisQuesos().get(i).getIdQueso()+":"+nombre+":"+Math.round(Fabrica.getInstance().getMisQuesos().get(i).calcularPrecio()*100.0)/100.0));
					 planDisponibleId.add(new String(Fabrica.getInstance().getMisQuesos().get(i).getIdQueso()));
			  } if(seleccion.equalsIgnoreCase("<Queso Cilindrico Hueco>")) {
					 nombre = "Queso Cilíndrico Hueco ";
					 planDisponible.add(new String(Fabrica.getInstance().getMisQuesos().get(i).getIdQueso()+":"+nombre+":"+Math.round(Fabrica.getInstance().getMisQuesos().get(i).calcularPrecio()*100.0)/100.0));
					 planDisponibleId.add(new String(Fabrica.getInstance().getMisQuesos().get(i).getIdQueso()));
			  } if(seleccion.equalsIgnoreCase("<Queso Esferico>")) {
					 nombre = "Queso Esférico ";
					 planDisponible.add(new String(Fabrica.getInstance().getMisQuesos().get(i).getIdQueso()+":"+nombre+":"+Math.round(Fabrica.getInstance().getMisQuesos().get(i).calcularPrecio()*100.0)/100.0));
					 planDisponibleId.add(new String(Fabrica.getInstance().getMisQuesos().get(i).getIdQueso()));
				 }
		 }	*/
		}
		listPlanDisponible.removeAll();
		listPlanDisponible.setListData(planDisponible.toArray());
		
	}
	public void actualizarMonto() {
		ArrayList<Plan> aux = Altice.getInstance().getMisPlanes();
		total = 0;
			for (Plan plan : aux) {
				for(int i=0; i<planFacturarId.size();i++) {
					if(plan.getCodPlan().equalsIgnoreCase(planFacturarId.get(i))) {
						total= total + plan.getPrecio() ;
					}
				}					
			}
			DecimalFormat d = new DecimalFormat("###.##");
			txtITBIS.setText(String.valueOf(Double.valueOf(d.format(total*0.18))));
			txtCDS.setText(String.valueOf(Double.valueOf(d.format(total*0.02))));
			txtISC.setText(String.valueOf(Double.valueOf(d.format(total*0.10))));
			total = total +total*0.30;
		txtTotal.setText(String.valueOf(Double.valueOf(d.format(total))));
	}
	private void clean() {
		txtCodFac.setText("F-"+Altice.getInstance().getFactCod());		
		}
	public ArrayList<Plan> cargarPlanes() {
		ArrayList<Plan> aux= new ArrayList<>();
		ArrayList<Plan> todos = Altice.getInstance().getMisPlanes();
		for (Plan plan : todos) {
			for(int i=0; i<planFacturarId.size();i++) {
				if(plan.getCodPlan().equalsIgnoreCase(planFacturarId.get(i))) {
				aux.add(plan);
				}
			}
			
		}
		
		return aux;
	}
}