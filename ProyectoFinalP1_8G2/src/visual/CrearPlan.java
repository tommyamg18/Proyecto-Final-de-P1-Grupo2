package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;

public class CrearPlan extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodPlan;
	private JTextField txtNombre;
	private JTextField txtPrecioPlan;
	private JPanel panel_internet;
	private JPanel panel_voz;
    private JPanel panel_cable;
    private JCheckBox chckbxInternet;
    private JCheckBox chckbxVoz;
    private JCheckBox chckbxCable;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CrearPlan dialog = new CrearPlan();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CrearPlan() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\wilbe\\Downloads\\137349-200.png"));
		setTitle("Creaci\u00F3n de Planes");
		setBounds(100, 100, 779, 523);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "Informaci\u00F3n General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(10, 11, 733, 73);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("C\u00F3digo:");
			lblNewLabel.setBounds(10, 30, 46, 14);
			panel_1.add(lblNewLabel);
			
			txtCodPlan = new JTextField();
			txtCodPlan.setEditable(false);
			txtCodPlan.setBounds(64, 27, 116, 20);
			panel_1.add(txtCodPlan);
			txtCodPlan.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Nombre:");
			lblNewLabel_1.setBounds(241, 30, 90, 14);
			panel_1.add(lblNewLabel_1);
			
			txtNombre = new JTextField();
			txtNombre.setBounds(300, 27, 143, 20);
			panel_1.add(txtNombre);
			txtNombre.setColumns(10);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBorder(new TitledBorder(null, "Servicios", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_2.setBounds(10, 89, 733, 54);
			panel.add(panel_2);
			panel_2.setLayout(null);
			
			chckbxInternet = new JCheckBox("Internet");
			chckbxInternet.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(chckbxInternet.isSelected()) {
						panel_internet.setVisible(true);

					}else {
						panel_internet.setVisible(false);

					}
					
					
				}
			});
			chckbxInternet.setBounds(88, 17, 97, 23);
			panel_2.add(chckbxInternet);
			
			chckbxVoz = new JCheckBox("Voz");
			chckbxVoz.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(chckbxVoz.isSelected()) {
						panel_voz.setVisible(true);

					}else {
						panel_voz.setVisible(false);

					}
				}
			});
			chckbxVoz.setBounds(338, 17, 97, 23);
			panel_2.add(chckbxVoz);
			
			chckbxCable = new JCheckBox("Cable");
			chckbxCable.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(chckbxCable.isSelected()) {
						panel_cable.setVisible(true);

					}else {
						panel_cable.setVisible(false);

					}
				}
			});
			chckbxCable.setBounds(579, 17, 97, 23);
			panel_2.add(chckbxCable);
			
			panel_internet = new JPanel();
			panel_internet.setVisible(false);
			panel_internet.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Servicio de Internet", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_internet.setBounds(10, 154, 733, 65);
			panel.add(panel_internet);
			panel_internet.setLayout(null);
			
			JLabel lblNewLabel_4 = new JLabel("Velocidad Subida:");
			lblNewLabel_4.setBounds(40, 28, 131, 14);
			panel_internet.add(lblNewLabel_4);
			
			JComboBox cmbVelSub = new JComboBox();
			cmbVelSub.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "1.5 Mbps", "2 Mbps"}));
			cmbVelSub.setBounds(154, 25, 151, 20);
			panel_internet.add(cmbVelSub);
			
			JLabel lblNewLabel_5 = new JLabel("Velocidad Bajada:");
			lblNewLabel_5.setBounds(430, 28, 124, 14);
			panel_internet.add(lblNewLabel_5);
			
			JComboBox cmbVelBaj = new JComboBox();
			cmbVelBaj.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "3 Mbps", "5 Mbps"}));
			cmbVelBaj.setBounds(544, 25, 151, 20);
			panel_internet.add(cmbVelBaj);
			
			panel_voz = new JPanel();
			panel_voz.setVisible(false);
			panel_voz.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Servicio de Voz", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_voz.setBounds(10, 230, 733, 70);
			panel.add(panel_voz);
			panel_voz.setLayout(null);
			
			JLabel lblNewLabel_6 = new JLabel("Minutos Nacionales:");
			lblNewLabel_6.setBounds(40, 29, 121, 14);
			panel_voz.add(lblNewLabel_6);
			
			JLabel lblNewLabel_7 = new JLabel("Minutos Internacionales:");
			lblNewLabel_7.setBounds(418, 29, 179, 14);
			panel_voz.add(lblNewLabel_7);
			
			JSpinner spnMinNac = new JSpinner();
			spnMinNac.setModel(new SpinnerNumberModel(200, 200, 800, 1));
			spnMinNac.setBounds(171, 26, 84, 20);
			panel_voz.add(spnMinNac);
			
			JSpinner spnMinInt = new JSpinner();
			spnMinInt.setModel(new SpinnerNumberModel(200, 200, 400, 1));
			spnMinInt.setBounds(568, 26, 76, 20);
			panel_voz.add(spnMinInt);
			
			panel_cable = new JPanel();
			panel_cable.setVisible(false);
			panel_cable.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Servicio de Cable", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_cable.setBounds(10, 311, 733, 65);
			panel.add(panel_cable);
			panel_cable.setLayout(null);
			
			JLabel lblNewLabel_8 = new JLabel("Cantidad de Canales:");
			lblNewLabel_8.setBounds(42, 28, 142, 14);
			panel_cable.add(lblNewLabel_8);
			
			JLabel lblNewLabel_9 = new JLabel("Cantidad de Canales HD:");
			lblNewLabel_9.setBounds(419, 28, 142, 14);
			panel_cable.add(lblNewLabel_9);
			
			JComboBox cmbCanal = new JComboBox();
			cmbCanal.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "170\t", "193", "241", "284"}));
			cmbCanal.setBounds(177, 25, 142, 20);
			panel_cable.add(cmbCanal);
			
			JComboBox cmbCanalHD = new JComboBox();
			cmbCanalHD.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "5", "23", "57"}));
			cmbCanalHD.setBounds(570, 25, 136, 20);
			panel_cable.add(cmbCanalHD);
			
			JLabel lblNewLabel_3 = new JLabel("Precio:");
			lblNewLabel_3.setBounds(555, 401, 46, 14);
			panel.add(lblNewLabel_3);
			
			txtPrecioPlan = new JTextField();
			txtPrecioPlan.setBounds(606, 398, 137, 20);
			panel.add(txtPrecioPlan);
			txtPrecioPlan.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnCrear = new JButton("Crear");
				btnCrear.setActionCommand("OK");
				buttonPane.add(btnCrear);
				getRootPane().setDefaultButton(btnCrear);
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
