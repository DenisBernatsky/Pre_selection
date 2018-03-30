package P1.calculator;

public class Operations {

    private double addition(double a, double b) {
        return a + b;
    }

    private double subtraction(double a, double b) {
        return a - b;
    }

    private double multiplication(double a, double b) {
        return a * b;
    }

    private double division(double a, double b) {
        return a / b;
    }

    public double actions(double a, double b, String operator){
        if ("+".equals(operator)) {
            return addition(a, b);
        } else if ("-".equals(operator)) {
            return subtraction(a, b);
        } else if ("/".equals(operator)) {
            return division(a, b);
        } else if ("*".equals(operator)) {
            return multiplication(a, b);
        } else {
            throw new IllegalArgumentException("incorrect operator: " + operator);
        }
    }
}
