package visual;

import java.awt.BorderLayout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logic.Altice;
import logic.Plan;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class ListarPlan extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3884285610758462580L;
	private final JPanel contentPanel = new JPanel();
    private JButton btnVer;
	private JButton btnEliminar;
    private JButton btnCancelar;
    private JTable table;
	public static DefaultTableModel modelo;
	public Plan aux=null;
	public static Object[] filas;
	private JPanel panel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListarPlan dialog = new ListarPlan();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListarPlan() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\wilbe\\Downloads\\listar.png"));
		setTitle("Listado de Planes");
		setBounds(100, 100, 657, 407);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			
			{
				
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panel.add(scrollPane);
				{
					modelo = new DefaultTableModel();
					String[] headers = {"Código","Nombre","Internet","Voz","Cable", "Precio"};
					modelo.setColumnIdentifiers(headers);
					table = new JTable();
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							int seleccion = table.getSelectedRow();
							if(seleccion!=-1){
							  btnEliminar.setEnabled(true);
							  btnVer.setEnabled(true);
								aux = Altice.getInstance().consultarPlan((String)modelo.getValueAt(seleccion, 0));
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
				btnVer = new JButton("Ver");
				btnVer.setEnabled(false);
				btnVer.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						CrearPlan newPlan = new CrearPlan(1,aux,null);
						newPlan.setVisible(true);
						llenarTabla();
						btnVer.setEnabled(false);
					}
				});
				buttonPane.add(btnVer);
			}
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.setEnabled(false);
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							if(aux!=null) {
							int option = JOptionPane.showConfirmDialog(null, "Está seguro que desea eliminar el plan: "+aux.getCodPlan(), "Confirmación", JOptionPane.WARNING_MESSAGE);
							if(option == JOptionPane.OK_OPTION) {
								Altice.getInstance().eliminarPlan(aux);
								llenarTabla();
								btnEliminar.setEnabled(false);
								btnVer.setEnabled(false);

							}
						}
						
					}
				});
				btnEliminar.setActionCommand("OK");
				buttonPane.add(btnEliminar);
				getRootPane().setDefaultButton(btnEliminar);
			}
			{
				btnCancelar = new JButton("Cancelar");
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
		for (Plan plan : Altice.getInstance().getMisPlanes()) {
			filas[0] = plan.getCodPlan();
			filas[1] = plan.getNombre();
			if(plan.isInternet())
			{
				filas[2] = "Habilitado";
			}
			else {
				filas[2] = "Deshabilitado";

			}
				if(plan.isVoz())
			{

				filas[3] =  "Habilitado";
			}
			else {
				
				filas[3] = "Deshabilitado";

				}	
			if(plan.isCable())
			{
				filas[4] = "Habilitado";
			}
			else {
				filas[4] = "Deshabilitado";

			}
			filas[5] = "RD$: "+plan.getPrecio();
			modelo.addRow(filas);
		}

	}

}
    