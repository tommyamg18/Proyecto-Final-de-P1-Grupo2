package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logic.Altice;
import logic.Cliente;


public class RegCliente extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5681658721527682954L;
	/**
	 * 
	 */
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtCedula;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private String auxTitle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegCliente dialog = new RegCliente(0,null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @param string2 
	 * @param i 
	 * @param ring 
	 */
	public RegCliente(int i, String cedula) {
		if(cedula== null) {
			auxTitle="Agregar";
		}else {
			auxTitle="Modificar";
		}
		setTitle(auxTitle+" Cliente");
		setLocationRelativeTo(null);
		setBounds(100, 100, 656, 430);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JLayeredPane layeredPane = new JLayeredPane();
			contentPanel.add(layeredPane);
		}
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaci\u00F3n Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			contentPanel.add(panel);
			
			JLabel lblNewLabel = new JLabel("Nombre:");
			lblNewLabel.setBounds(15, 34, 115, 33);
			panel.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("C\u00E9dula:");
			lblNewLabel_1.setBounds(15, 96, 115, 33);
			panel.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("Direcci\u00F3n:");
			lblNewLabel_2.setBounds(13, 158, 118, 33);
			panel.add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel("Tel\u00E9fono:");
			lblNewLabel_3.setBounds(15, 220, 115, 33);
			panel.add(lblNewLabel_3);
			
			txtNombre = new JTextField();
			txtNombre.setBounds(134, 31, 454, 39);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			
			txtCedula = new JTextField();
			txtCedula.setColumns(10);
			txtCedula.setBounds(134, 93, 454, 39);
			panel.add(txtCedula);
			
			txtDireccion = new JTextField();
			txtDireccion.setColumns(10);
			txtDireccion.setBounds(134, 155, 454, 39);
			panel.add(txtDireccion);
			
			txtTelefono = new JTextField();
			txtTelefono.setColumns(10);
			txtTelefono.setBounds(134, 217, 454, 39);
			panel.add(txtTelefono);
			
			if(i==1) {
				Cliente cliente = Altice.getInstance().buscarCliente(cedula);
				txtCedula.setText(cliente.getCedula());
				txtNombre.setText(cliente.getNombre());
				txtDireccion.setText(cliente.getDireccion());
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton Agregar = new JButton(auxTitle);
				Agregar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(i==0) {
							boolean verificar = false;
							for(int i=0; i<Altice.getInstance().getMisClientes().size(); i++) {
								if(Altice.getInstance().getMisClientes().get(i).getCedula().equalsIgnoreCase(txtCedula.getText())) {
									verificar = true;
								}
								
							}
							if(verificar==true) {
								JOptionPane.showMessageDialog(null, "Cedula Duplicada", "Error", JOptionPane.ERROR_MESSAGE);
								txtCedula.setText("");
							}
							else {
								Cliente newCliente = new Cliente(txtCedula.getText(), txtNombre.getText(), txtDireccion.getText(), txtTelefono.getText());
								Altice.getInstance().insertarCliente(newCliente);
					//			RegFactura newFac = new RegFactura(0,newCliente);
						//		newFac.setVisible(true);
								dispose();
							}
					}else if(i==1) {
						int option = JOptionPane.showConfirmDialog(null, "Esta seguro que desea actualizar la informacion del cliente seleccionado", "Confirmacion", JOptionPane.WARNING_MESSAGE);
						if(option==JOptionPane.OK_OPTION) {
							Cliente cliente = Altice.getInstance().buscarCliente(cedula);
							cliente.setCedula(txtCedula.getText());
							cliente.setNombre(txtNombre.getText());
							cliente.setDireccion(txtDireccion.getText());
							clean();
							dispose();
						}
						if(option!=JOptionPane.OK_OPTION) {
							clean();
							dispose();
						}
					}
						}
					
				});
				Agregar.setActionCommand("OK");
				buttonPane.add(Agregar);
				getRootPane().setDefaultButton(Agregar);
			}
			{
				JButton cancelButton = new JButton("Cancel");
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

	public void clean() {
		txtCedula.setText("");
		txtNombre.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
	}
}
