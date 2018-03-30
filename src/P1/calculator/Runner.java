package P1.calculator;

import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {

        Operations calculator = new Operations();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение в формате '2 + 5' или '3.1 * 4'");

        if (scanner.findInLine("(-?\\d+\\.?\\d*)?\\s*(\\S)\\s*(-?\\d+\\.?\\d*)") != null) {
            if (scanner.match().group(1) != null && scanner.match().group(2) != null) {
                Double nOne = Double.parseDouble(scanner.match().group(1));
                Double nTwo = Double.parseDouble(scanner.match().group(3));
                Double result = calculator.actions(nOne, nTwo, scanner.match().group(2));
                System.out.println("Результат = " + result);
            }
            else {
                throw new IllegalArgumentException("Не верные значения. Первое число = " + scanner.match().group(1) + " Второе число = " + scanner.match().group(3));
            }
        }
        else {
            throw new IllegalArgumentException("Не верный формат записи");

        }
    }
}
