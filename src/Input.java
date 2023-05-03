import Storage.Storage;

import java.util.Scanner;

public class Input {
    Scanner scanner = new Scanner(System.in);

    public int chooseFunction() {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("Численное дифференцирование Метод Эйлера");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("Выберите номер уравнения:");
        System.out.println(Storage.printAllFunction());
        System.out.println("------------------------------------------------------------------------------");
        String s;
        while(true) {
            s = scanner.nextLine();
            try {
                int num = Integer.parseInt(s);
                if (num < 4 && num > 0) {
                    return num;
                }
                System.out.println("Ошибка! Номер должен задаваться числом от 1 и до 3");
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Номер должен задаваться числом");
            }
        }
    }
    public int getApproximate() {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("Выберите аппроксимирующую функцию: \n 1)Линейная y = kx + b \n 2)Экспоненциальная функция y = be^(ax) \n 3)Квадратичная y = ax^2 + bx + c");
        System.out.println("------------------------------------------------------------------------------");
        String s;
        while(true) {
            s = scanner.nextLine();
            try {
                int num = Integer.parseInt(s);
                if (num < 4 && num > 0) {
                    System.out.println("------------------------------------------------------------------------------");
                    return num;
                }
                System.out.println("Ошибка! Номер должен задаваться числом от 1 и до 3");
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Номер должен задаваться числом");
            }
        }
    }

    public double chooseLeftBoard(){
        System.out.println("Выберите нижнюю границу:");
        System.out.println("------------------------------------------------------------------------------");
        String s;
        while(true) {
            s = scanner.nextLine();
            try {
                double num = Double.parseDouble(s);
                return num;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Граница должна задаваться числом");
            }
        }
    }

    public double chooseRightBoard(){
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("Выберите верхнюю границу:");
        System.out.println("------------------------------------------------------------------------------");
        String s;
        while(true) {
            s = scanner.nextLine();
            try {
                double num = Double.parseDouble(s);
                return num;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Граница должна задаваться числом");
            }
        }
    }
    public double getH() {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("Введите размер шага");
        double h;
        String s;
        while (true) {
            s = scanner.nextLine();
            try {
                h = Double.parseDouble(s);
                if (h > 0.0D) {
                    break;
                }
                System.out.println("Ошибка! Размер шага должен быть больше 0");
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Размер шага должен задаваться числом");
            }
        }
        return h;
    }

    public double getZeroCoordinate() {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("Введите значение y0: ");
        double y0;
        String s;
        while (true) {
            s = scanner.nextLine();
            try {
                y0 = Double.parseDouble(s);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Значение должно задаваться числом");
            }
        }
        return y0;
    }

}
