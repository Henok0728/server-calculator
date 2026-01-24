package Calculator;
import java.lang.ArithmeticException;

interface operations{
    double add (double a , double b);
    double sub (double a , double b);
    double mult(double a, double b);
    double div (double a , double b);
}
public class Calculator implements operations{
    public Calculator(){
    }
    @Override
    public double add(double a , double b){
        return a + b;
    }
    @Override
    public double sub(double a , double b){
        return a - b;
    }
    @Override
    public double mult(double a , double b){
        return a * b;
    }
    @Override
    public double div(double a, double b){
        try{
            double result = (double) a / b;
            return result;
        }
        catch(ArithmeticException e){
            throw new ArithmeticException("Divison by zero is not allowed");
        }
    }
    public double calculate(int n1, int n2, char op){
            Calculator calc = new Calculator();
            double result = 0;
            switch(op){
                case '+':
                    result = calc.add(n1,n2);
                    break;
                case '-':
                    result = calc.sub(n1,n2);
                    break;
                case '*':
                    result = calc.mult(n1,n2);
                    break;
                case '/':
                    result = calc.div(n1,n2);
                    break;
                default:
                    System.out.println("invalid operation");
            }
            return result;
        }
    
}
