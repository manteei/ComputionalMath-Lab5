package Drawer;

import Storage.Storage;
import org.knowm.xchart.*;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.style.lines.SeriesLines;
import org.knowm.xchart.style.markers.SeriesMarkers;

import java.awt.*;

public class ChartDrawer {
    private int type;
    private int number;
    private double[][] result;
    private double[] coeff;
    private double[] coeff2;
    Color color1 = new Color(44, 44, 246);
    Color color2 = new Color(226, 5, 163);
    Color color3 = new Color(62, 170, 79);
    Color color4 = new Color(243, 169, 9);

    public ChartDrawer(double[][] result, double[]coeff, double[] coeff2, int number, int type){
        this.result = result;
        this.coeff = coeff;
        this.number = number;
        this.coeff2 = coeff2;
        this.type=type;
    }
     public void draw(){
         double[] xData = new double[result[0].length];
         double[] yData = new double[result[0].length];
         for (int i = 0; i < result[0].length; i++) {
             double x  = result[0][0]+i*((result[0][result.length]-result[0][0])/result.length);
             xData[i] = x;
             if (type == 2) {
                 yData[i] = Storage.getExponentialFunctionWithCoefficient(x, coeff[0], coeff[1]);
             }else if (type == 3){
                 yData[i] = Storage.getQuadraticFunctionWithCoefficient(x, coeff[0], coeff[1], coeff[2]);
             }
         }

         double[] xData2 = new double[result[0].length];
         double[] yData2 = new double[result[0].length];
         for (int i = 0; i < result[0].length; i++) {
             double x  = result[0][0]+i*((result[0][result.length]-result[0][0])/result.length);
             xData2[i] = x;
             if (type == 2) {
                 yData2[i] = Storage.getExponentialFunctionWithCoefficient(x, coeff2[0], coeff2[1]);
             }else if (type==3) {
                 yData2[i] = Storage.getQuadraticFunctionWithCoefficient(x, coeff2[0], coeff2[1], coeff2[2]);
             }
         }

         XYChart chart = new XYChartBuilder()
                 .width(1400)
                 .height(800)
                 .title("Численное дифференцирование" + Storage.printFunction(number))
                 .xAxisTitle("X")
                 .yAxisTitle("Y")
                 .build();

         String name2 = "Решение методом Эйлера\n";
         XYSeries privateSolution = chart.addSeries(name2, result[0], result[1]);
         privateSolution.setMarker(SeriesMarkers.NONE);
         privateSolution.setLineStyle(SeriesLines.SOLID);
         privateSolution.setLineColor(color3);

         String name3 = "Аналитическое решение\n";
         XYSeries analyticSolution = chart.addSeries(name3, result[0], result[2]);
         analyticSolution.setMarker(SeriesMarkers.NONE);
         analyticSolution.setLineStyle(SeriesLines.DASH_DASH);
         analyticSolution.setLineColor(color1);

         String name1 = "Аппроксимация решения\n метода Эйлера\n" + Storage.printApproximation(type, coeff);
         XYSeries firstApproximationDraw = chart.addSeries(name1, xData, yData);
         firstApproximationDraw.setMarker(SeriesMarkers.NONE);
         firstApproximationDraw.setLineStyle(SeriesLines.SOLID);
         firstApproximationDraw.setLineColor(color4);

         String name4 = "Аппроксимация аналитического \n решения\n" + Storage.printApproximation(type, coeff2);
         XYSeries secondApproximationDraw = chart.addSeries(name4, xData2, yData2);
         secondApproximationDraw.setMarker(SeriesMarkers.NONE);
         secondApproximationDraw.setLineStyle(SeriesLines.DASH_DASH);
         secondApproximationDraw.setLineColor(color2);

         new SwingWrapper(chart).displayChart();
     }

}
