import com.calculator.Calculator;
import com.calculator.CalculatorException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Calculator calculator = new Calculator();
        try {
            System.out.println(calculator.calculateString(scanner.nextLine()));
        } catch (CalculatorException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
