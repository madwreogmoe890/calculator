import com.calculator.Calculator;
import com.calculator.CalculatorException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
            FileWriter output = new FileWriter("output.txt", false);
            output.write(String.valueOf(calculator.calculateString(line)));
            output.flush();
        } catch (CalculatorException exception) {
            System.out.println(exception.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
