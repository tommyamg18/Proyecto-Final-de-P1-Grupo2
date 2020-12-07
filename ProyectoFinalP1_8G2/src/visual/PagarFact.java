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
	private String identificacion;
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtCodFac;
	private int index=-1;
	private int indexBack =-1;
	private String seleccion = "<Todos>";
    private ArrayList<String> Disponible;
    private ArrayList<String> DisponibleId=new ArrayList<>();
    private ArrayList<String> Facturar = new ArrayList<>();
	private ArrayList<String> FacturarId = new ArrayList<>();
	private double total=0;
	public Plan aux=null;
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
			PagarFact dialog = new PagarFact(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PagarFact( Factura miFac) {
		setTitle("Pago Factura");
		setBounds(100, 100, 1098, 388);
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
			
			
		}
		clean();
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Pagar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						miFac.setPagada(true);
						JOptionPane.showMessageDialog(null, "Pago satisfactorio", "Información", JOptionPane.INFORMATION_MESSAGE);
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
		if(miFac!=null) {
			cargarDatos(miFac.getMicliente());
			actualizarMonto(miFac);
		}
		
	}



	protected void cargarDatos(Cliente client) {	
		txtCedula.setText(client.getCedula());
		txtNombre.setText(client.getNombre());
		txtDireccion.setText(client.getDireccion());
		txtTelefono.setText(client.getTelefono());
	}

	public void actualizarMonto(Factura miFac) {
		DecimalFormat d = new DecimalFormat("######.##");
			total = miFac.getTotal();
			txtTotal.setText(String.valueOf(Double.valueOf(d.format(total))));
			total = total-total*0.3;
			txtITBIS.setText(String.valueOf(Double.valueOf(d.format(total*0.18))));
			txtCDS.setText(String.valueOf(Double.valueOf(d.format(total*0.02))));
			txtISC.setText(String.valueOf(Double.valueOf(d.format(total*0.10))));
	}
	private void clean() {
		txtCodFac.setText("F-"+Altice.getInstance().getFactCod());		
		}
}