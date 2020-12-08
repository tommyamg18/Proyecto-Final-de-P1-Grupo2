package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.Altice;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2338171001859749383L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					int aux1 = 1;
					int aux2 = 1;
					int aux3 = 1;
					Altice.getInstance().setPlanCod(aux1);
					Altice.getInstance().setFactCod(aux2);
					Altice.getInstance().setNunCon(aux3);
					Principal frame = new Principal();
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
	public Principal() {
		setTitle("Sistema Altice ");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/images/logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 952, 586);
		setLocationRelativeTo(null);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				FileOutputStream empresa2;
				ObjectOutputStream empresaWrite;
				try {
					empresa2 = new  FileOutputStream("Altice.dat");
					empresaWrite = new ObjectOutputStream(empresa2);
					empresaWrite.writeObject(Altice.getInstance());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		JMenu mnNewMenu = new JMenu("Clientes");
		mnNewMenu.setIcon(new ImageIcon(Principal.class.getResource("/images/cliente.png")));
		/*if(!Altice.getLoginPersonal().getTipo().equalsIgnoreCase("Administrador")){
		mnNewMenu.setEnabled(true);
	    }*/
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Listar ");
		mntmNewMenuItem_1.setIcon(new ImageIcon(Principal.class.getResource("/images/listaricon.png")));

		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListCliente lisClient = new ListCliente();
				lisClient.setModal(true);
				lisClient.setLocationRelativeTo(null);
				lisClient.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("Facturaci\u00F3n");
		mnNewMenu_1.setIcon(new ImageIcon(Principal.class.getResource("/images/facturacion.png")));

		/*if(!Altice.getLoginPersonal().getTipo().equalsIgnoreCase("Administrador")){
		mnNewMenu_1.setEnabled(true);
	    }*/
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Crear");
		mntmNewMenuItem_2.setIcon(new ImageIcon(Principal.class.getResource("/images/crear.png")));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConfirmacionCliente nue = new ConfirmacionCliente(0);
				nue.setVisible(true);
				nue.setLocationRelativeTo(null);
				nue.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmListar = new JMenuItem("Listar");
		mntmListar.setIcon(new ImageIcon(Principal.class.getResource("/images/listaricon.png")));

		mntmListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfirmacionCliente nue = new ConfirmacionCliente(1);
				nue.setVisible(true);
				nue.setLocationRelativeTo(null);
				nue.setVisible(true);

			}
		});
		mnNewMenu_1.add(mntmListar);
		
		JMenu mnNewMenu_2 = new JMenu("Planes");
		mnNewMenu_2.setIcon(new ImageIcon(Principal.class.getResource("/images/planes.png")));

		/*if(!Altice.getLoginPersonal().getTipo().equalsIgnoreCase("Comercial")){
		mnNewMenu_2.setEnabled(true);
	    }*/
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Crear");
		mntmNewMenuItem_4.setIcon(new ImageIcon(Principal.class.getResource("/images/crear.png")));

		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				CrearPlan crearPlan = new CrearPlan(0,null,null);
				crearPlan.setModal(true);
				crearPlan.setLocationRelativeTo(null);
				crearPlan.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Listar");
		mntmNewMenuItem_5.setIcon(new ImageIcon(Principal.class.getResource("/images/listaricon.png")));
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarPlan listarPlan = new ListarPlan();
				listarPlan.setModal(true);
				listarPlan.setLocationRelativeTo(null);
				listarPlan.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_3 = new JMenu("Personal");
		mnNewMenu_3.setIcon(new ImageIcon(Principal.class.getResource("/images/personal.png")));

		/*if(!Altice.getLoginPersonal().getTipo().equalsIgnoreCase("Comercial")){
		mnNewMenu_3.setEnabled(true);
	    }*/
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Agregar");
		mntmNewMenuItem_6.setIcon(new ImageIcon(Principal.class.getResource("/images/crear.png")));

		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegPersonal regpersonal = new RegPersonal();
				regpersonal.setModal(true);
				regpersonal.setLocationRelativeTo(null);
				regpersonal.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Listar ");
		mntmNewMenuItem_7.setIcon(new ImageIcon(Principal.class.getResource("/images/listaricon.png")));
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarPersonal listpersonal = new ListarPersonal();
				listpersonal.setModal(true);
				listpersonal.setLocationRelativeTo(null);
				listpersonal.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_7);
		
		JMenu mnNewMenu_4 = new JMenu("Estadisticas");
		mnNewMenu_4.setIcon(new ImageIcon(Principal.class.getResource("/images/estadisticas.png")));

		/*if(!Altice.getLoginPersonal().getTipo().equalsIgnoreCase("Comercial")){
		mnNewMenu_4.setEnabled(true);
	    }*/
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Cantidad de Usuarios por Plan");
		mntmNewMenuItem_8.setIcon(new ImageIcon(Principal.class.getResource("/images/grafica.png")));
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GraficaUsuariosPlan grafica1 = new GraficaUsuariosPlan();
				//grafica1.setModal(true);
				grafica1.setLocationRelativeTo(null);
				grafica1.setVisible(true);
			
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Ingresos de las Facturas por Mes");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GraficaDineroPagado grafica2 = new GraficaDineroPagado();
				//grafica1.setModal(true);
				grafica2.setLocationRelativeTo(null);
				grafica2.setVisible(true);
			}
		});
		mntmNewMenuItem_9.setIcon(new ImageIcon(Principal.class.getResource("/images/grafica.png")));

		mnNewMenu_4.add(mntmNewMenuItem_9);
		
		JMenu mnNewMenu_5 = new JMenu("Reportes");
		mnNewMenu_5.setIcon(new ImageIcon(Principal.class.getResource("/images/reporte.png")));

		/*if(!Altice.getLoginPersonal().getTipo().equalsIgnoreCase("Comercial")){
		mnNewMenu_5.setEnabled(true);
	    }*/
		menuBar.add(mnNewMenu_5);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Cantidad de Personal");
		mntmNewMenuItem.setIcon(new ImageIcon(Principal.class.getResource("/images/reporte2.png")));

		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReporteCantidaddePersonal reporte1 = new ReporteCantidaddePersonal();
				reporte1.setModal(true);
				reporte1.setLocationRelativeTo(null);
				reporte1.setVisible(true);
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Facturas Pagadas");
		mntmNewMenuItem_3.setIcon(new ImageIcon(Principal.class.getResource("/images/reporte1.png")));
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReporteFacturasPagadasoNo reporte2 = new ReporteFacturasPagadasoNo();
				reporte2.setModal(true);
				reporte2.setLocationRelativeTo(null);
				reporte2.setVisible(true);
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_3);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
	}
}
