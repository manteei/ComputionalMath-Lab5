import Approximation.Approximation;
import Approximation.Exponential;
import Approximation.Linear;
import Approximation.Quadratic;
import Drawer.ChartDrawer;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();
        Solution solution = new Solution();
        Approximation functionType;
        int number = input.chooseFunction();
        int type = input.getApproximate();
        double a = input.chooseLeftBoard();
        double b = input.chooseRightBoard();
        double h = input.getH();
        double y0 = input.getZeroCoordinate();
        if (type == 1){
            functionType = new Linear();
        }else if (type == 2){
            functionType = new Exponential();
        }else {
            functionType = new Quadratic();
        }
        double[][] result = solution.getResult(a, b, h, y0, number);
        double[] coeff = functionType.getCoefficient(result[0], result[1]);
        double[] coeff2 = functionType.getCoefficient(result[0], result[2]);
        ChartDrawer chartDrawer = new ChartDrawer(result, coeff, coeff2, number, type);
        chartDrawer.draw();

    }
}
