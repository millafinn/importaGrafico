package org.example;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->{
            //Crie uma série de dados XY para função f(x) = x
            XYSeries series = new XYSeries("f(x) = x");
            for (double x = -10; x <= 10; x += 0.1){

                series.add(x, - x);
            }

            //Crie um conjunto de dados com a série XY
            XYSeriesCollection dataset = new XYSeriesCollection(series);

            //Crie o gráfico
            JFreeChart chart =  ChartFactory.createXYLineChart("Gráfico da Função f(x) = x",
                    "x", "f(x)", dataset, PlotOrientation.VERTICAL,
                    true, true, false);

            //Crie uma janela para exibir o gráfico
            JFrame frame = new JFrame("Gráfico da Função");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new ChartPanel(chart));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}