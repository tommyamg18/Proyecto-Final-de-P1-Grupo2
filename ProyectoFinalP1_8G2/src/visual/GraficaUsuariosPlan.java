package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import logic.Altice;


public class GraficaUsuariosPlan extends JFrame {
	JPanel panel;
    public GraficaUsuariosPlan(){
        setTitle("Grafico De La Cantidad De Usuarios Por Cada Plan");
        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
     //   init();
    //}
 
   // public void init() {
        panel = new JPanel();
        getContentPane().add(panel);
        // Fuente de Datos
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        ArrayList<Integer> cant = Altice.getInstance().cantidadUsuariosCadaPlan();
        //cant.set(0, 5);
        dataset.setValue(cant.get(0), "Cable", "");
        dataset.setValue(cant.get(1), "Voz", "");
        dataset.setValue(cant.get(2), "Internet", "");
        dataset.setValue(cant.get(3), "Voz y Cable", "");
        dataset.setValue(cant.get(4), "Voz e Internet", "");
        dataset.setValue(cant.get(5), "Cable e Internet", "");
        dataset.setValue(cant.get(6), "Voz, Cable e Internet", "");

        
        // Creando el Grafico
        JFreeChart chart = ChartFactory.createBarChart3D
        ("Usuarios Por Plan","Planes", "Cantidad de usuarios", 
        dataset, PlotOrientation.VERTICAL, true,true, false);
        chart.setBackgroundPaint(Color.white);
        chart.getTitle().setPaint(Color.black); 
        CategoryPlot p = chart.getCategoryPlot(); 
        p.setRangeGridlinePaint(Color.red); 
        // Mostrar Grafico
        ChartPanel chartPanel = new ChartPanel(chart);
        panel.add(chartPanel);
    }
    
    public static void main(String args[]){
        new GraficaUsuariosPlan().setVisible(true);
    }
}