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

public class GraficaDineroPagado extends JFrame {

	JPanel panel;
    public GraficaDineroPagado(){
        setTitle("Grafico Del Dinero Pagado");
        setSize(800,500);
        setLocationRelativeTo(null);
        setVisible(true);
        init();
    }
 
    private void init() {
        panel = new JPanel();
        getContentPane().add(panel);
        // Fuente de Datos
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        ArrayList<Double> dinero = Altice.getInstance().cantidadDeDineroMes();
        //cant.set(0);
        dataset.setValue(dinero.get(0), "Enero", "");
        dataset.setValue(dinero.get(1), "Febrero", "");
        dataset.setValue(dinero.get(2), "Marzo", "");
        dataset.setValue(dinero.get(3), "Abril", "");
        dataset.setValue(dinero.get(4), "Mayo", "");
        dataset.setValue(dinero.get(5), "Junio", "");
        dataset.setValue(dinero.get(6), "Julio", "");
        dataset.setValue(dinero.get(7), "Agosto", "");
        dataset.setValue(dinero.get(8), "Septiembre", "");
        dataset.setValue(dinero.get(9), "Octubre", "");
        dataset.setValue(dinero.get(10),"Noviembre", "");
        dataset.setValue(dinero.get(11),"Diciembre", "");

        
        // Creando el Grafico
        JFreeChart chart = ChartFactory.createBarChart3D
        ("Dinero de Facturas Pagadas","Pagos Realizados Por Mes", "Cantidad de Dinero Por Mes", 
        dataset, PlotOrientation.VERTICAL, true,true, false);
        chart.setBackgroundPaint(Color.white);
        chart.getTitle().setPaint(Color.black); 
        CategoryPlot p = chart.getCategoryPlot(); 
        p.setRangeGridlinePaint(Color.red); 
        // Mostrar Grafico
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setMinimumDrawWidth(800);
        panel.add(chartPanel);
    }
    
    /*public static void main(String args[]){
        new GraficaDineroPagado().setVisible(true);
    }*/
}