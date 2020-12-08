package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import logic.Administrativo;
import logic.Altice;
import logic.Personal;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField passwordField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				FileInputStream empresa;
				FileOutputStream empresa2;
				ObjectInputStream empresaRead;
				ObjectOutputStream empresaWrite;
				try {
					empresa = new FileInputStream ("Altice.dat");
					empresaRead = new ObjectInputStream(empresa);
					Altice temp = (Altice)empresaRead.readObject();
					Altice.setAltice(temp);
					empresa.close();
					empresaRead.close();
				} catch (FileNotFoundException e) {
					try {
						empresa2 = new  FileOutputStream("Altice.dat");
						empresaWrite = new ObjectOutputStream(empresa2);
						Personal aux = new Personal("0", "", "", "", "0", 1, "ADM");
						Altice.getInstance().registrarPersonal(aux);
						empresaWrite.writeObject(Altice.getInstance());
						empresa2.close();
						empresaWrite.close();
					} catch (FileNotFoundException e1) {
					} catch (IOException e1) {
						// TODO Auto-generated catch block
					}
				} catch (IOException e) {
					
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Login");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/images/logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 366);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setBounds(120, 77, 74, 14);
		panel.add(lblNewLabel);
		
		txtUser = new JTextField();
		/*try {
 			MaskFormatter formatouser;
 			formatouser = new MaskFormatter("###-#######-#");
 			formatouser.setPlaceholderCharacter('_');
 			txtUser = new JFormattedTextField(formatouser);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		txtUser.setBounds(204, 74, 168, 20);
		panel.add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_1.setBounds(120, 159, 93, 14);
		panel.add(lblNewLabel_1);
		
		JButton btnAcceder = new JButton("Acceder");
		btnAcceder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char[] arrayC = passwordField.getPassword();
				String pass = new String(arrayC);
	      if(!txtUser.getText().equalsIgnoreCase("") && !(pass.equalsIgnoreCase(""))){
	    		System.out.println(txtUser.getText());
	    		//System.out.println(Altice.getInstance().getMiPersonal());

				//if(Altice.getAdministrador().getCedula().equalsIgnoreCase("0") && Altice.getAdministrador().getPassword().equalsIgnoreCase("0")){
				if(Altice.getInstance().confirmarLogin(txtUser.getText(), pass)){
		    		System.out.println(txtUser.getText());

					Principal frame = new Principal();
					frame.setVisible(true);
					txtUser.setText("");
					passwordField.setText("");
					dispose();
					
				}
	    	  
	      } 
	      else{
				
				JOptionPane.showMessageDialog(null, "Verifique que todos los campos estén llenos", null, JOptionPane.ERROR_MESSAGE, null);

			}
	
			}
		});
		btnAcceder.setBounds(204, 229, 89, 23);
		panel.add(btnAcceder);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(204, 156, 168, 20);
		panel.add(passwordField);
	}
}
