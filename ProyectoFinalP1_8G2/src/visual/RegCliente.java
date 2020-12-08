package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

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
	private JFormattedTextField txtCedula;
	private JTextField txtDireccion;
	private JFormattedTextField txtTelefono;
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
		if(i== 0) {
			auxTitle="Agregar";
		}if(i==1){
			auxTitle="Modificar";
		}
		setTitle(auxTitle+" Cliente");
		setBounds(100, 100, 656, 430);
		setLocationRelativeTo(null);
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
			txtNombre.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c=e.getKeyChar();
					if((c<'a'||c>'z') && (c<'A'||c>'Z') && (c<'á'||c>'ú') && (c<' '||c>' ') && (c<'.'|| c>'.' ))e.consume();
				}
			});
			txtNombre.setBounds(134, 31, 454, 39);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			
			txtCedula = new JFormattedTextField((AbstractFormatter) null);
			try {
				MaskFormatter formatoCedula= new MaskFormatter("###-#######-#");
				formatoCedula.setPlaceholderCharacter('_');
				txtCedula = new JFormattedTextField(formatoCedula);			
			}catch (Exception e) {
				// TODO: handle exception
			}
			txtCedula.setColumns(10);
			txtCedula.setBounds(134, 93, 454, 39);
			panel.add(txtCedula);
			
			txtDireccion = new JTextField();
			txtDireccion.setColumns(10);
			txtDireccion.setBounds(134, 155, 454, 39);
			panel.add(txtDireccion);
			
			txtTelefono = new JFormattedTextField((AbstractFormatter) null);
			try {
				MaskFormatter formatoTele= new MaskFormatter("(###)-###-####");
				formatoTele.setPlaceholderCharacter('_');
				txtTelefono = new JFormattedTextField(formatoTele);			
			}catch (Exception e) {
				// TODO: handle exception
			}
			txtTelefono.setColumns(10);
			txtTelefono.setBounds(134, 217, 454, 39);
			panel.add(txtTelefono);
			
			if(i==1) {
				Cliente cliente = Altice.getInstance().buscarCliente(cedula);
				txtCedula.setText(cliente.getCedula());
				txtNombre.setText(cliente.getNombre());
				txtDireccion.setText(cliente.getDireccion());
			}
			if(i==0 & cedula!=null) {
				txtCedula.setText(cedula);
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
								txtCedula.setText("_-__-");
							}
							else {
								if(comprobacionaDatos()) {
								Cliente newCliente = new Cliente(txtCedula.getText(), txtNombre.getText(), txtDireccion.getText(), txtTelefono.getText());
								Altice.getInstance().insertarCliente(newCliente);
								Facturacion newFact = new Facturacion(0,newCliente);
								newFact.setVisible(true);
								dispose();
								}else {
									JOptionPane.showMessageDialog(null, "Comprobar que todos los datos fueron llenados", "Error", JOptionPane.ERROR_MESSAGE);
									clean();
								}
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

	protected boolean comprobacionaDatos() {
		boolean aux=true;
		if(txtCedula.getText().equalsIgnoreCase("_-__-")) {
			aux=false;
		}
		if(txtNombre.getText().equalsIgnoreCase("")) {
			aux=false;
		}
		if(txtDireccion.getText().equalsIgnoreCase("")) {
			aux=false;
		}
		if(txtTelefono.getText().equalsIgnoreCase("(_)-_-__")) {
			aux=false;
		}
		return aux;
	}

	public void clean() {
		txtCedula.setText("_-__-");
		txtNombre.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("(_)-_-__");
	}
}
