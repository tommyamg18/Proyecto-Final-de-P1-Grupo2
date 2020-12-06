package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import logic.Altice;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setBounds(120, 77, 74, 14);
		panel.add(lblNewLabel);
		
		txtUser = new JTextField();
		try {
 			MaskFormatter formatouser;
 			formatouser = new MaskFormatter("###-#######-#");
 			formatouser.setPlaceholderCharacter('_');
 			txtUser = new JFormattedTextField(formatouser);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtUser.setBounds(204, 74, 168, 20);
		panel.add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_1.setBounds(120, 159, 93, 14);
		panel.add(lblNewLabel_1);
		
		JButton btnAcceder = new JButton("Acceder");
		btnAcceder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	      if(!txtUser.getText().equalsIgnoreCase("___-_______-_") && !String.valueOf(passwordField.getPassword()).equalsIgnoreCase("")){
	    		if(Altice.getInstance().confirmarLogin(txtUser.getText(),String.valueOf(passwordField.getPassword()))){
					Principal frame = new Principal();
					txtUser.setText("");
					passwordField.setText("");
					dispose();
					frame.setVisible(true);
					
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
