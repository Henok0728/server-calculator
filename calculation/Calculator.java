import java.io.*;
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
    
}
