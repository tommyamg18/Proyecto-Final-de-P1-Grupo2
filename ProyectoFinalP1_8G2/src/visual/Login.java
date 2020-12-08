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
import javax.swing.ImageIcon;
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
import java.awt.Font;
import java.awt.Color;

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
		setResizable(false);
		setTitle("Login");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/images/logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 736, 466);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(21, 187, 74, 14);
		panel.add(lblNewLabel);
		
		txtUser = new JTextField();
		txtUser.setBackground(Color.LIGHT_GRAY);
		/*try {
 			MaskFormatter formatouser;
 			formatouser = new MaskFormatter("###-#######-#");
 			formatouser.setPlaceholderCharacter('_');
 			txtUser = new JFormattedTextField(formatouser);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		txtUser.setBounds(105, 184, 168, 20);
		panel.add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(21, 240, 93, 14);
		panel.add(lblNewLabel_1);
		
		JButton btnAcceder = new JButton("Acceder");
		btnAcceder.setIcon(new ImageIcon(Login.class.getResource("/images/acceder.png")));
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
		btnAcceder.setBounds(105, 305, 116, 23);
		panel.add(btnAcceder);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(Color.LIGHT_GRAY);
		passwordField.setBounds(105, 237, 168, 20);
		panel.add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("\u00A1Bienvenido/a a Altice!");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel_2.setBounds(21, 85, 273, 44);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Por favor ingrese sus credenciales debajo ");
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(10, 130, 458, 23);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Principal.class.getResource("/images/al.jpg")));
		lblNewLabel_4.setBounds(-74, -149, 1313, 929);
		panel.add(lblNewLabel_4);
	}
}
