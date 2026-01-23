package socketpro;
interface operations{
    double add (double a , double b);
    double sub (double a , double b);
    double mult(double a, double b);
    double div (double a , double b);
}
public class calculator implements operations{
    public calculator(){
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
        if (b==0){
            throw new ArithmeticException();
        }
        double result = (double) a / b;
        return result;
    }
    
}
