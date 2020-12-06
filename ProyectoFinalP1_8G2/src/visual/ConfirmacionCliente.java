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

import logic.Altice;
import logic.Cliente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfirmacionCliente extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1240921974650145134L;
	/**
	 * 
	 */
	private final JPanel contentPanel = new JPanel();
	private JFormattedTextField textField;
	private JRadioButton rdbtnExistente;
	private JRadioButton rdbtnNuevo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ConfirmacionCliente dialog = new ConfirmacionCliente(0);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConfirmacionCliente(int i) {
		setResizable(false);
		setTitle("Opciones de Clientes");
		setBounds(100, 100, 492, 328);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Opciones de Clientes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(11, 0, 460, 221);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seleccionar tipo de Cliente");
		lblNewLabel.setBounds(53, 46, 338, 33);
		panel.add(lblNewLabel);
		
		textField = new JFormattedTextField((AbstractFormatter) null);
		try {
			MaskFormatter formatoCedula= new MaskFormatter("###-#######-#");
			formatoCedula.setPlaceholderCharacter('_');
			textField = new JFormattedTextField(formatoCedula);			
		}catch (Exception e) {
			// TODO: handle exception
		}
		textField.setEditable(false);
		textField.setBounds(104, 159, 236, 39);
		panel.add(textField);
		textField.setColumns(10);
		
		rdbtnNuevo = new JRadioButton("Nuevo");
		rdbtnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdbtnNuevo.setSelected(true);
				rdbtnExistente.setSelected(false);
				textField.setEditable(false);
			}
		});
		rdbtnNuevo.setSelected(true);
		rdbtnNuevo.setBounds(271, 90, 167, 41);
		panel.add(rdbtnNuevo);
		
		rdbtnExistente = new JRadioButton("Existente");
		rdbtnExistente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdbtnNuevo.setSelected(false);
				rdbtnExistente.setSelected(true);
				textField.setEditable(true);
			}
		});
		rdbtnExistente.setBounds(63, 90, 184, 41);
		panel.add(rdbtnExistente);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Confirmar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(i==0) {
						if(rdbtnExistente.isSelected()) {
							Cliente miCliente = Altice.getInstance().buscarCliente(textField.getText());
							if(miCliente!= null) {
							Facturacion newFact = new Facturacion(0,miCliente);
							newFact.setVisible(true);
							dispose();
							}else {
								JOptionPane.showMessageDialog(null, "Cedula No encontrada, \nPor favor Verificar", "Error", JOptionPane.ERROR_MESSAGE);
								textField.setText("");
							}
						}else if(rdbtnNuevo.isSelected()) {
							RegCliente newClient = new RegCliente(0, null);
							newClient.setVisible(true);
							dispose();
						}
					}
					if(i==1) {
						if(rdbtnExistente.isSelected()) {
							Cliente miCliente = Altice.getInstance().buscarCliente(textField.getText());

							if(miCliente!= null) {
								ListaFactura newFact = new ListaFactura(miCliente.getCedula());
							newFact.setVisible(true);
							dispose();
							}else {
								JOptionPane.showMessageDialog(null, "Cedula No encontrada, \nPor favor Verificar", "Error", JOptionPane.ERROR_MESSAGE);
								textField.setText("___-_______-_");
							}
						}}
					}});
				okButton.setActionCommand("ok");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
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
		if(i==1) {
			rdbtnNuevo.setSelected(false);
			rdbtnNuevo.setVisible(false);
			rdbtnNuevo.setEnabled(false);
			rdbtnExistente.setSelected(true);
			rdbtnExistente.setVisible(false);
			textField.setEnabled(true);
			textField.setEditable(true);
			lblNewLabel.setText("Digite Cedula de cliente que \n quiere ver consultar");
		}
	}
	
}
