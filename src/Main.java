import com.calculator.Calculator;
import com.calculator.CalculatorException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String filename = "input.txt";
        Scanner scanner;
        try {
            scanner = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            System.out.println("Error! " + filename + " not found");
            return;
        }

        Calculator calculator = new Calculator();
        String line = scanner.nextLine();
        System.out.println(line);
        try {
            System.out.println(calculator.calculateString(line));
        } catch (CalculatorException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
