package Storage;

import java.text.DecimalFormat;

public class Storage {
    public static double getLinearFunctionWithCoefficient(double x, double k, double b){
       return k*x+b;
    }
    public static double getExponentialFunctionWithCoefficient(double x, double k, double b){
        return k*Math.exp(b * x);
    }
    public static double getQuadraticFunctionWithCoefficient(double x, double a, double b, double c){
        return a * Math.pow(x, 2)+b*x+c;
    }

    public static double getFunction1(double x, double y) {
        return x*y;
    }
    public static double getFunction2(double x, double y) {
        return Math.pow(x, 2)-2*y;
    }
    public static double getFunction3(double x, double y) {
        return  Math.sin(x)+y;
    }

    public static double getFunction(double x, double y, int n){
        if (n==1) return getFunction1(x, y);
        else if (n==2) return getFunction2(x, y);
        else return getFunction3(x, y);
    }

    public static String printFunction(int n){
        if (n==1) return "y' = xy/2";
        else if (n==2) return "y' = x^2 - 2y";
        else return "y' = sin(x) + y";
    }
    public static String printApproximation(int type, double [] coeff) {
        DecimalFormat df = new DecimalFormat("#.########");
        String result;
        if (type == 1) result = df.format(coeff[0]) + "x + " + df.format(coeff[1]);
        else if (type == 2) result = df.format(coeff[0]) + "e^" + df.format(coeff[1]) + "x";
        else result = df.format(coeff[0]) + "x^2 + " + df.format(coeff[1]) + "x + " + df.format(coeff[2]);
        return result;
    }
    public static String printAllFunction(){
        return " 1)y' = xy/2 \n 2)y' = x^2 - 2y \n 3)y' = sin(x) + y";
    }

}
