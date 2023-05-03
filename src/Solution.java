import Storage.Storage;
public class Solution {

    public double[][] getResult(double a, double b, double h, double y0, int num) {
        int n = (int) ((b - a) / h) + 1;
        double[] x = new double[n];
        double[] y = new double[n];
        double[] yAnalytic = new double[n];
        x[0] = a;
        y[0] = y0;
        for (int i = 1; i < n; i++) {
            x[i] = x[i-1] + h;
            y[i] = y[i-1] + h * f(x[i-1], y[i-1], num);
            yAnalytic[i] = getAnalyticSolution(num, x[i], y[i]);
        }
        yAnalytic[0]=y0;
        double[][] result = new double[][]{x, y, yAnalytic};
        return result;
    }

    private double getAnalyticSolution(int num, double x, double y){
        double c;
        double yAnalytic = 0;
        if (num == 1) {
            c = y / Math.pow(Math.E, Math.pow(x, 2) / 2);
            yAnalytic = c * Math.pow(Math.E, Math.pow(x, 2) / 2);
        }else if (num == 2){
            c = y - 0.5 * Math.pow(x, 2) + 0.5 * x - 0.25 / (Math.pow(Math.E, -2 * x));
            yAnalytic = c * Math.pow(Math.E, -2 * x) + 0.5 * Math.pow(x, 2) - 0.5 * x + 0.25;
        }else if (num == 3){
            c=(y + Math.sin(x) / 2 + Math.cos(x) / 2) / Math.pow(Math.E, x);
            yAnalytic = -Math.sin(x) / 2 - Math.cos(x) / 2 + c * Math.pow(Math.E, x);
        }
        return yAnalytic;
    }

    private double f(double x, double y, int num) {
        return Storage.getFunction(x, y, num);
    }
}

