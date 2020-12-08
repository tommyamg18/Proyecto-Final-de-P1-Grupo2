package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import logic.Administrativo;
import logic.Altice;
import logic.Comercial;
import logic.Personal;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class RegPersonal extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JTextField txtSueldo;
	private JTextField txtPass;
	private JTextField txtPuesto;
	private JPanel panel_general;
    private JComboBox cmbTipo;
    private JPanel panel_admin;
    private int index;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegPersonal dialog = new RegPersonal();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegPersonal() {
		setTitle("Registro de Personal");
		setBounds(100, 100, 384, 517);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPanel.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		panel_general = new JPanel();
		panel_general.setBorder(new TitledBorder(null, "Informaci\u00F3n General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_general.setBounds(10, 11, 338, 323);
		panel.add(panel_general);
		panel_general.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tipo:");
		lblNewLabel.setBounds(20, 33, 46, 14);
		panel_general.add(lblNewLabel);
		
		cmbTipo = new JComboBox();
		cmbTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index = cmbTipo.getSelectedIndex();
				if(index==0) {
					panel_admin.setVisible(false);
				}
				else if(index==1) {
					panel_admin.setVisible(true);
				}
				else if(index==2) {
					panel_admin.setVisible(false);

				}	
			}
		});
		cmbTipo.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Administrativo", "Comercial"}));
		cmbTipo.setBounds(102, 30, 146, 20);
		panel_general.add(cmbTipo);
		
		JLabel lblNewLabel_1 = new JLabel("C\u00E9dula:");
		lblNewLabel_1.setBounds(20, 75, 72, 14);
		panel_general.add(lblNewLabel_1);
		
		txtCedula = new JTextField();
 		try {
 			MaskFormatter formatocedula;
 			formatocedula = new MaskFormatter("###-#######-#");
 			formatocedula.setPlaceholderCharacter('_');
 			txtCedula = new JFormattedTextField(formatocedula);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtCedula.setBounds(102, 72, 146, 20);
		panel_general.add(txtCedula);
		txtCedula.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		lblNewLabel_2.setBounds(20, 117, 57, 14);
		panel_general.add(lblNewLabel_2);
		
		txtNombre = new JTextField();
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if((c<'a'||c>'z') && (c<'A'||c>'Z') && (c<'á'||c>'ú') && (c<' '||c>' ') && (c<'.'|| c>'.' ))e.consume();
			}
		});
		txtNombre.setBounds(103, 114, 214, 20);
		panel_general.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Tel\u00E9fono:");
		lblNewLabel_3.setBounds(20, 161, 57, 14);
		panel_general.add(lblNewLabel_3);
		
		txtTelefono = new JTextField();
		try {
 			MaskFormatter formatotelefono;
 			formatotelefono = new MaskFormatter("(###) ###-####");
 			formatotelefono.setPlaceholderCharacter('_');
 			txtTelefono = new JFormattedTextField(formatotelefono);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtTelefono.setBounds(102, 158, 146, 20);
		panel_general.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Direcci\u00F3n:");
		lblNewLabel_4.setBounds(20, 202, 57, 14);
		panel_general.add(lblNewLabel_4);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(103, 199, 214, 20);
		panel_general.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Sueldo:");
		lblNewLabel_5.setBounds(20, 242, 57, 14);
		panel_general.add(lblNewLabel_5);
		
		txtSueldo = new JTextField();
		txtSueldo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if((c<'0'||c>'9') && (c<'.'|| c>'.' ))e.consume();}
		});
		txtSueldo.setBounds(102, 239, 146, 20);
		panel_general.add(txtSueldo);
		txtSueldo.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_6.setBounds(20, 282, 72, 14);
		panel_general.add(lblNewLabel_6);
		
		txtPass = new JTextField();
		txtPass.setBounds(102, 279, 146, 20);
		panel_general.add(txtPass);
		txtPass.setColumns(10);
		
		panel_admin = new JPanel();
		panel_admin.setVisible(false);
		panel_admin.setBorder(new TitledBorder(null, "Departamento Administrativo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_admin.setBounds(10, 345, 338, 65);
		panel.add(panel_admin);
		panel_admin.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Puesto:");
		lblNewLabel_7.setBounds(21, 29, 53, 14);
		panel_admin.add(lblNewLabel_7);
		
		txtPuesto = new JTextField();
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if((c<'a'||c>'z') && (c<'A'||c>'Z') && (c<'á'||c>'ú') && (c<' '||c>' ') && (c<'.'|| c>'.' ))e.consume();
			}
		});
		txtPuesto.setBounds(104, 26, 212, 20);
		panel_admin.add(txtPuesto);
		txtPuesto.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("Registrar");
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
		               if(index!=0 && !txtNombre.getText().equalsIgnoreCase("") && !txtCedula.getText().equalsIgnoreCase("_-__-") && !txtTelefono.getText().equalsIgnoreCase("(_) _-__") && !txtDireccion.getText().equalsIgnoreCase("") && !txtSueldo.getText().equalsIgnoreCase("") && !txtPass.getText().equalsIgnoreCase("")){
							
							if(index==1 && !txtPuesto.getText().equalsIgnoreCase("")) {
								String cedula = txtCedula.getText();
								String nombre = txtNombre.getText();
								String telefono = txtTelefono.getText();
								String direccion = txtDireccion.getText();
								Double sueldo = Double.parseDouble(txtSueldo.getText());
								String password = txtPass.getText();
								String puesto = txtPuesto.getText();
								String tipo = cmbTipo.getSelectedItem().toString();
								Administrativo aux = new Administrativo(cedula, nombre, telefono, direccion, password,sueldo,tipo, puesto);		
								Altice.getInstance().registrarPersonal(aux);
								JOptionPane.showMessageDialog(null, "Administrativo registrado satisfactoriamente", null, JOptionPane.INFORMATION_MESSAGE, null);
								clear();
								
							}
							
							if(index==2) {
								String cedula = txtCedula.getText();
								String nombre = txtNombre.getText();
								String telefono = txtTelefono.getText();
								String direccion = txtDireccion.getText();
								Double sueldo = Double.parseDouble(txtSueldo.getText());
								String password = txtPass.getText();
								String tipo = cmbTipo.getSelectedItem().toString();
								Comercial aux = new Comercial(cedula, nombre, telefono, direccion, password,sueldo,tipo,-1);		
								Altice.getInstance().registrarPersonal(aux);
								JOptionPane.showMessageDialog(null, "Comercial registrado satisfactoriamente", null, JOptionPane.INFORMATION_MESSAGE, null);
								clear();
							}
							
						} 
		               else {
							JOptionPane.showMessageDialog(null, "Debe llenar todos los campos", null, JOptionPane.ERROR_MESSAGE, null);

						}

					
					}

					private void clear() {
						
						txtCedula.setText("");
						txtNombre.setText("");
						txtTelefono.setText("");
						txtDireccion.setText("");
						txtSueldo.setText("");
						txtPass.setText("");
						txtPuesto.setText("");		
						cmbTipo.setSelectedIndex(0);
					}
				});
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
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
	}
}