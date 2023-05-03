package Approximation;

import EqSystem.EqSolution;

public class Quadratic implements Approximation{
    EqSolution eqSolution = new EqSolution();
    public double[] getCoefficient(double [] x, double[] y){
        return eqSolution.getResult(getEguation(x, y), getResEquation(x, y));
    }
    public double[][] getEguation(double[] x, double[] y){
        return new double[][]{
                {getSumX4(x), getSumX3(x), getSumX2(x)},
                {getSumX3(x), getSumX2(x), getSumX(x)},
                {getSumX2(x), getSumX(x), x.length}
        };
    }
    public double[] getResEquation(double[] x, double[] y) {
        return new double[]{getSumX2Y(x, y), getSumXY(x, y), getSumY(y)};
    }
}
