import com.calculator.Calculator;
import com.calculator.CalculatorException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    private final static Calculator calculator = new Calculator();
    private static Scanner input;
    private static FileWriter output;

    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        try {
            initStreams(inputFile, outputFile);

            while (input.hasNext()) {
                processLine(input.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error! " + inputFile + " not found");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void initStreams(String inputFile, String outputFile) throws IOException {
        input = new Scanner(new File(inputFile));
        output = new FileWriter(outputFile, false);
    }

    private static void processLine(String line) throws IOException {
        if (line.isEmpty()) {
            return;
        }
        String result;
        try {
            result = String.valueOf(calculator.calculateString(line));
        } catch (CalculatorException exception) {
            result = exception.getMessage();
        }
        output.write(line + " = " + result + "\n");
        output.flush();
    }
}
