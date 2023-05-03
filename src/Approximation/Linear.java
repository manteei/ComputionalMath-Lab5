package Approximation;

import EqSystem.EqSolution;

public class Linear implements Approximation {
    EqSolution eqSolution = new EqSolution();
    public double[] getCoefficient(double [] x, double[] y){
       return eqSolution.getResult(getEguation(x, y), getResEquation(x, y));
    }
    public double[][] getEguation(double[] x, double[] y){
        return new double[][]{
                {x.length, getSumX(x)},
                {getSumX(x), getSumX2(x)}
        };
    }
    public double[] getResEquation(double[] x, double[] y) {
        return new double[]{getSumY(y), getSumXY(x, y)};
    }
}
