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

public class PagarFact extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7285987465287828314L;
	/**
	 * 
	 */
	private final JPanel contentPanel = new JPanel();
	private String cedula;
	private JList listFacturar;
	private JList listDisponible;
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
    private ArrayList<String> Disponible;
    private ArrayList<String> DisponibleId=new ArrayList<>();
    private ArrayList<String> Facturar = new ArrayList<>();
	private ArrayList<String> FacturarId = new ArrayList<>();
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
			PagarFact dialog = new PagarFact(0,null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PagarFact(int mod, Cliente miCliente) {
		setTitle("Pago Factura");
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
			panel_1.setBackground(new Color(240, 240, 240));
			panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Facturas vencidas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_1.setBounds(26, 208, 429, 288);
			panel.add(panel_1);
			panel_1.setLayout(new BorderLayout(0, 0));
			
			listDisponible = new JList();
			listDisponible.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					index = listDisponible.getSelectedIndex();
					if(index!=-1){
						btnAgregar.setEnabled(true);
					}
				}
			});
			panel_1.add(listDisponible, BorderLayout.CENTER);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Facturas a pagar:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_2.setBounds(580, 208, 429, 288);
			panel.add(panel_2);
			panel_2.setLayout(new BorderLayout(0, 0));
			
			listFacturar = new JList();
			panel_2.add(listFacturar, BorderLayout.CENTER);
			listFacturar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					indexBack = listFacturar.getSelectedIndex();
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
						Facturar.add(Disponible.get(index));
						FacturarId.add(DisponibleId.get(index));
						Disponible.remove(index);
						DisponibleId.remove(index);
						listDisponible.removeAll();
						listDisponible.setListData(Disponible.toArray());
						listFacturar.removeAll();
						listFacturar.setListData(Facturar.toArray());
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
						  Disponible.add(Facturar.get(indexBack));
						  DisponibleId.add(FacturarId.get(indexBack));
						  Facturar.remove(indexBack);
						  FacturarId.remove(indexBack);
						  listDisponible.removeAll();
						  listDisponible.setListData(Disponible.toArray());
						  listFacturar.removeAll();
						  listFacturar.setListData(Facturar.toArray());
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
						aux = new Factura (codFactura, miCliente, null, cargarPlanes(),Double.valueOf(txtTotal.getText()),false);
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
		for (String Seleccion : FacturarId) {
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
		Disponible = new ArrayList<>();
		if(seleccion.equalsIgnoreCase("<Todos>")){ 
		 for (int i = 0; i < Altice.getInstance().getMisPlanes().size(); i++) {

		   Disponible.add(new String(Altice.getInstance().getMisFacturas().get(i).getCodFact() +" : "+Altice.getInstance().getMisFacturas().get(i).getFecha()+" : "+Math.round(Altice.getInstance().getMisPlanes().get(i).getPrecio()*100.0)/100.0));
		   DisponibleId.add(new String(Altice.getInstance().getMisPlanes().get(i).getCodPlan()));
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
		listDisponible.removeAll();
		listDisponible.setListData(Disponible.toArray());
		
	}
	public void actualizarMonto() {
		ArrayList<Factura> aux = Altice.getInstance().getMisFacturas();
		total = 0;
			for (Factura plan : aux) {
				for(int i=0; i<FacturarId.size();i++) {
					if(plan.getCodFact().equalsIgnoreCase(FacturarId.get(i))) {
						total= total + plan.getTotal();
					}
				}					
			}
			DecimalFormat d = new DecimalFormat("######.##");
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
			for(int i=0; i<FacturarId.size();i++) {
				if(plan.getCodPlan().equalsIgnoreCase(FacturarId.get(i))) {
				aux.add(plan);
				}
			}
			
		}
		
		return aux;
	}
}