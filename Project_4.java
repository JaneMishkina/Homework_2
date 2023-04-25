// К калькулятору из предыдущего дз добавить логирование.

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.*;

public class Project_4{
    public static void main(String[] args) throws SecurityException, IOException {
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введите первое число: ");
        double a = iScanner.nextFloat(); 
        System.out.printf("Введите оператор (+, -, , /): ");
        String operator = iScanner.next();
        System.out.printf("Введите второе число: ");
        double b = iScanner.nextFloat(); 
        iScanner.close();
        String res = null;
        Logger logger = Logger.getLogger(Homework_4.class.getName());
        FileHandler info = new FileHandler("log2.xml");


        switch (operator) {
            case "+":
            res = String.format("%.2f + %.2f = %.2f\n", a, b, a + b);
            break;

            case "-":
                res = String.format("%.2f + %.2f = %.2f\n", a, b, a - b);
                break;

            case "*":
                res = String.format("%.2f * %.2f = %.2f\n", a, b, a * b);
                break;

            case "/":
                if (b == 0) {
                    res = "На ноль делить нельзя!";
                } else {
                    res = String.format("%.2f / %.2f = %.2f\n", a, b, a / b);
                }
                break;
        }
        logger.addHandler(info);
        logger.info(res);
        System.out.println(res);
    }
}