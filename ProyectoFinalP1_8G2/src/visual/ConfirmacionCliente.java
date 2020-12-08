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
	private JFormattedTextField txtCed;
	private JLabel lblCed;
	private JLabel lblTitulo;
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
		setBounds(100, 100, 471, 255);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Opciones de Clientes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(11, 0, 441, 167);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		lblTitulo = new JLabel("Seleccionar tipo de Cliente");
		lblTitulo.setBounds(20, 31, 338, 33);
		panel.add(lblTitulo);
		
		txtCed = new JFormattedTextField((AbstractFormatter) null);
		try {
			MaskFormatter formatoCedula= new MaskFormatter("###-#######-#");
			formatoCedula.setPlaceholderCharacter('_');
			txtCed = new JFormattedTextField(formatoCedula);
			txtCed.setVisible(false);
		}catch (Exception e) {
			// TODO: handle exception
		}
		txtCed.setEditable(false);
		txtCed.setBounds(199, 104, 236, 39);
		panel.add(txtCed);
		txtCed.setColumns(10);
		
		rdbtnNuevo = new JRadioButton("Nuevo");
		rdbtnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdbtnNuevo.setSelected(true);
				rdbtnExistente.setSelected(false);
				txtCed.setEditable(false);
				txtCed.setVisible(false);
				lblCed.setVisible(false);

			}
		});
		rdbtnNuevo.setSelected(true);
		rdbtnNuevo.setBounds(268, 62, 167, 41);
		panel.add(rdbtnNuevo);
		
		rdbtnExistente = new JRadioButton("Existente");
		rdbtnExistente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdbtnNuevo.setSelected(false);
				rdbtnExistente.setSelected(true);
				txtCed.setEditable(true);
				txtCed.setVisible(true);
				lblCed.setVisible(true);
			}
		});
		rdbtnExistente.setBounds(57, 62, 190, 41);
		panel.add(rdbtnExistente);
		
		lblCed = new JLabel("Digite C\u00E9dula:");
		lblCed.setVisible(false);
		lblCed.setBounds(20, 104, 173, 33);
		panel.add(lblCed);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Confirmar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(i==0) {
						if(rdbtnExistente.isSelected()) {
							Cliente miCliente = Altice.getInstance().buscarCliente(txtCed.getText());
							if(miCliente!= null) {
							Facturacion newFact = new Facturacion(0,miCliente);
							newFact.setVisible(true);
							dispose();
							}else {
								JOptionPane.showMessageDialog(null, "Cedula No encontrada, \nPor favor Verificar", "Error", JOptionPane.ERROR_MESSAGE);
								txtCed.setText("");
							}
						}else if(rdbtnNuevo.isSelected()) {
							RegCliente newClient = new RegCliente(0, null);
							newClient.setVisible(true);
							dispose();
						}
					}
					if(i==1) {
						if(rdbtnExistente.isSelected()) {
							Cliente miCliente = Altice.getInstance().buscarCliente(txtCed.getText());

							if(miCliente!= null) {
								ListaFactura newFact = new ListaFactura(miCliente.getCedula());
							newFact.setVisible(true);
							dispose();
							}else {
								JOptionPane.showMessageDialog(null, "Cedula No encontrada, \nPor favor Verificar", "Error", JOptionPane.ERROR_MESSAGE);
								txtCed.setText("___-_______-_");
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
			txtCed.setEnabled(true);
			txtCed.setEditable(true);
			txtCed.setVisible(true);
			lblTitulo.setText("Digite Cedula de cliente que \n quiere ver consultar");
		}
	}
}

