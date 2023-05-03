package Approximation;

import java.util.Arrays;

public interface Approximation {
    default double getSumX(double[] x){
        return Arrays.stream(x).sum();
    }
    default double getSumY(double[] y){
        return Arrays.stream(y).sum();
    }
    default double getSumX2(double[] x){
        return Arrays.stream(x).map(el -> Math.pow(el, 2)).sum();
    }
    default double getSumX3(double[] x){
        return Arrays.stream(x).map(el -> Math.pow(el, 3)).sum();
    }
    default double getSumX4(double[] x){
        return Arrays.stream(x).map(el -> Math.pow(el, 4)).sum();
    }
    default double getSumXY(double[] x, double[] y){
        double result = 0;
        for (int i = 0; i < x.length; i++) {
            result += x[i] * y[i];
        }
        return result;
    }
    default double getSumX2Y(double[] x, double[] y){
        double result = 0;
        for (int i = 0; i < x.length; i++) {
            result += Math.pow(x[i], 2) * y[i];
        }
        return result;
    }
    default double getSumLnY(double[] y){
        return Arrays.stream(y).map(el -> Math.log(el)).sum();
    }
    default double getSumXLnY(double[] x, double[] y){
        double result = 0;
        for (int i = 0; i < x.length; i++) {
            result += x[i] * Math.log(y[i]);
        }
        return result;
    }
     double[] getCoefficient(double [] x, double[] y);
     double[][] getEguation(double[] x, double[] y);
    double[] getResEquation(double[] x, double[] y);

}
