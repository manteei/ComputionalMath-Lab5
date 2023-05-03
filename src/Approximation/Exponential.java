package Approximation;

import EqSystem.EqSolution;

public class Exponential implements Approximation{
    EqSolution eqSolution = new EqSolution();
    public double[] getCoefficient(double [] x, double[] y){
        double[] result = eqSolution.getResult(getEguation(x, y), getResEquation(x, y));
        result[0] = Math.exp(result[0]);
        return result;
    }
    public double[][] getEguation(double[] x, double[] y){
        return new double[][]{
                {x.length, getSumX(x)},
                {getSumX(x), getSumX2(x)}
        };
    }
    public double[] getResEquation(double[] x, double[] y) {
        return new double[]{getSumLnY(y), getSumXLnY(x, y)};
    }
}
