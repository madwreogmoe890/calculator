package com.calculator;

import java.util.InputMismatchException;
import java.util.Optional;

public class Calculator {
    public double calculateString(String line) throws CalculatorException {
        String[] args = line.split("\\s+");

        try {
            double a = Double.parseDouble(args[0]);
            double b = Double.parseDouble(args[2]);
            String operation = args[1];

            if (args.length != 3) {
                throw new InputMismatchException("Wrong argument count");
            }

            return calculate(a, b, operation);
        } catch (NumberFormatException exception) {
            throw new CalculatorException("Error! Not number");
        } catch (IllegalArgumentException | ArithmeticException | InputMismatchException exception) {
            throw new CalculatorException(ofNullable(exception.getMessage()).orElse("Unknown error"));
        }
    }

    private Optional<String> ofNullable(String message) {
        return Optional.ofNullable(message);
    }

    private double calculate(double a, double b, String operation) {
        switch (operation) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0) {
                    throw new ArithmeticException("Error! Division by zero");
                }
                return a / b;
            default:
                throw new IllegalArgumentException("Operation Error!");
        }
    }
}
