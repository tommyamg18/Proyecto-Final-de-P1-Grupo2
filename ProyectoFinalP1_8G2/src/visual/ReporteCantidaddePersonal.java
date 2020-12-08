package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logic.Administrativo;
import logic.Altice;
import logic.Comercial;
import logic.Personal;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class ReporteCantidaddePersonal extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	public static DefaultTableModel modelo;
	public static Object[] filas;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ReporteCantidaddePersonal dialog = new ReporteCantidaddePersonal();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ReporteCantidaddePersonal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ReporteCantidaddePersonal.class.getResource("/images/logo.png")));
		setTitle("Reporte de Cantidad del Personal");
		setBounds(100, 100, 528, 142);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
		panel = new JPanel();
		contentPanel.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		{
			
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			panel.add(scrollPane);
			{
				modelo = new DefaultTableModel();
				String[] headers = {"Tipo","Cantidad"};
				modelo.setColumnIdentifiers(headers);
				table = new JTable();
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int seleccion = table.getSelectedRow();
						if(seleccion!=-1){
						}
					}
				});
				table.setModel(modelo);
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				scrollPane.setViewportView(table);
			}
		}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
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
		llenarTabla();

	}
	
	public static void llenarTabla() {
		modelo.setRowCount(0);
		filas = new Object[modelo.getColumnCount()];	
		int cantComercial = 0;
		int cantAdministrativo = 0;
		for (Personal personal : Altice.getInstance().getMiPersonal()) {
			if(personal instanceof Administrativo) {
				cantAdministrativo++;
		    }
			if(personal instanceof Comercial) {
				cantComercial++;
		    }
		}
		for (int i = 0; i < 2; i++) {
			if(i==0){
			 filas[0] = "Administrativo";
			 filas[1] = cantAdministrativo;
			}
			if(i==1){
			 filas[0] = "Comercial";
		     filas[1] = cantComercial;
			}
			modelo.addRow(filas);
			}
			
		}

	}

