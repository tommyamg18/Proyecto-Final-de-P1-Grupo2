package visual;

import java.awt.BorderLayout;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logic.Altice;
import logic.Cliente;

public class ListCliente extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -238360082170351010L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	public static DefaultTableModel modelo;
	public static Object[] filas;
	public Cliente aux=null;
	private JButton btnEliminar;
	private JButton btnModificar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListCliente dialog = new ListCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListCliente() {		setTitle("Listado de Clientes");
	setModal(true);
	setLocationRelativeTo(null);
	setBounds(100, 100, 747, 468);
	setLocationRelativeTo(null);
	getContentPane().setLayout(new BorderLayout());
	contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	getContentPane().add(contentPanel, BorderLayout.CENTER);
	contentPanel.setLayout(new BorderLayout(0, 0));
	{
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPanel.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			panel.add(scrollPane, BorderLayout.CENTER);
			{
				modelo = new DefaultTableModel();
				String[] headers = {"Cedula", "Nombre", "Direccion", "Telefono"};
				modelo.setColumnIdentifiers(headers);
				table = new JTable();
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int seleccion = table.getSelectedRow();
						if(seleccion!=-1) {
							btnEliminar.setEnabled(true);
							btnModificar.setEnabled(true);
							aux = Altice.getInstance().buscarCliente((String)modelo.getValueAt(seleccion, 0));
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
		buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		{
			btnModificar = new JButton("Modificar");
			btnModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(aux!=null) {
						RegCliente reg = new RegCliente(1, aux.getCedula());
						reg.setModal(true);
						reg.setLocationRelativeTo(null);
						reg.setVisible(true);
						llenarTabla();
					}
				}
			});
			btnModificar.setEnabled(false);
			btnModificar.setActionCommand("OK");
			buttonPane.add(btnModificar);
			getRootPane().setDefaultButton(btnModificar);
		}
		{
			btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(aux!=null) {
						int option = JOptionPane.showConfirmDialog(null, "Esta seguro que desea eliminar al cliente: "+aux.getNombre(), "Confirmacion", JOptionPane.WARNING_MESSAGE);
						if(option == JOptionPane.OK_OPTION) {
							Altice.getInstance().eliminarCliente(aux);
							llenarTabla();
							btnEliminar.setEnabled(false);
						}
					}
				}
			});
			btnEliminar.setEnabled(false);
			buttonPane.add(btnEliminar);
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
	
	llenarTabla();
}

public static void llenarTabla() {
	modelo.setRowCount(0);
	filas = new Object[modelo.getColumnCount()];
	for (int i = 0; i<Altice.getInstance().getMisClientes().size(); i++) {
		filas[0] = Altice.getInstance().getMisClientes().get(i).getCedula();
		filas[1] = Altice.getInstance().getMisClientes().get(i).getNombre();
		filas[2] = Altice.getInstance().getMisClientes().get(i).getDireccion();
		filas[3] = Altice.getInstance().getMisClientes().get(i).getTelefono();
		modelo.addRow(filas);
	}
	
}

}
